package gallerees.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import gallerees.dao.AsetVisualDAO;
import gallerees.model.AsetVisual;
import gallerees.model.DesainVektor;
import gallerees.model.FotoKamera;

import javafx.stage.FileChooser;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class GaleriController implements Initializable {

    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtTema;
    @FXML
    private TextField txtPathFile;
    @FXML
    private ComboBox<String> cmbJenis;

    @FXML
    private Button btnSimpan;
    @FXML
    private Button btnUbah;
    @FXML
    private Button btnHapus;
    @FXML
    private Button btnBersihkan;

    @FXML
    private TableView<AsetVisual> tabelAset;
    @FXML
    private TableColumn<AsetVisual, Integer> colId;
    @FXML
    private TableColumn<AsetVisual, String> colNama;
    @FXML
    private TableColumn<AsetVisual, String> colTema;
    @FXML
    private TableColumn<AsetVisual, String> colJenis;
    @FXML
    private TableColumn<AsetVisual, String> colPath;

    @FXML
    private ImageView imgPreview;

    private final AsetVisualDAO dao = new AsetVisualDAO();
    private ObservableList<AsetVisual> dataList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbJenis.setItems(FXCollections.observableArrayList("Foto Kamera", "Desain Vektor"));
        cmbJenis.getSelectionModel().selectFirst();

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("namaAset"));
        colTema.setCellValueFactory(new PropertyValueFactory<>("tema"));
        colJenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        colPath.setCellValueFactory(new PropertyValueFactory<>("pathFile"));

        loadData();

        // listener baris tabel
        tabelAset.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        isiForm(newVal);
                        tampilkanGambar(newVal.getPathFile());

                        // polimorfism
                        newVal.tampilkanDetail();
                    }
                });
    }

    @FXML
    private void onBrowsePath() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Gambar Aset");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp"));
        File selectedFile = fileChooser.showOpenDialog(txtPathFile.getScene().getWindow());
        if (selectedFile != null) {
            txtPathFile.setText(selectedFile.getAbsolutePath().replace("\\", "/"));
            tampilkanGambar(txtPathFile.getText());
        }
    }

    @FXML
    private void onSimpan() {
        if (!validasiInput())
            return;

        AsetVisual aset = buatAsetDariForm();
        dao.insert(aset);
        loadData();
        bersihkanForm();
        showInfo("Data berhasil disimpan.");
    }

    @FXML
    private void onUbah() {
        AsetVisual selected = tabelAset.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showWarning("Pilih data yang ingin diubah di tabel terlebih dahulu.");
            return;
        }
        if (!validasiInput())
            return;

        AsetVisual aset = buatAsetDariForm();
        aset.setId(selected.getId());
        dao.update(aset);
        loadData();
        bersihkanForm();
        showInfo("Data berhasil diubah.");
    }

    @FXML
    private void onHapus() {
        AsetVisual selected = tabelAset.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showWarning("Pilih data yang ingin dihapus di tabel terlebih dahulu.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                "Yakin ingin menghapus \"" + selected.getNamaAset() + "\"?",
                ButtonType.YES, ButtonType.NO);
        confirm.setTitle("Konfirmasi Hapus");
        confirm.setHeaderText(null);
        confirm.showAndWait().ifPresent(btn -> {
            if (btn == ButtonType.YES) {
                dao.delete(selected.getId());
                loadData();
                bersihkanForm();
                imgPreview.setImage(null);
                showInfo("Data berhasil dihapus.");
            }
        });
    }

    @FXML
    private void onBersihkan() {
        bersihkanForm();
        imgPreview.setImage(null);
        tabelAset.getSelectionModel().clearSelection();
    }

    private void loadData() {
        dataList = FXCollections.observableArrayList(dao.getAll());
        tabelAset.setItems(dataList);
    }

    private AsetVisual buatAsetDariForm() {
        String nama = txtNama.getText().trim();
        String tema = txtTema.getText().trim();
        String pathFile = txtPathFile.getText().trim();
        String jenis = cmbJenis.getValue();

        if ("Desain Vektor".equals(jenis)) {
            return new DesainVektor(0, nama, tema, pathFile);
        } else {
            return new FotoKamera(0, nama, tema, pathFile);
        }
    }

    private void isiForm(AsetVisual aset) {
        txtNama.setText(aset.getNamaAset());
        txtTema.setText(aset.getTema());
        txtPathFile.setText(aset.getPathFile());
        cmbJenis.setValue(aset.getJenis());
    }

    private void bersihkanForm() {
        txtNama.clear();
        txtTema.clear();
        txtPathFile.clear();
        cmbJenis.getSelectionModel().selectFirst();
    }

    private void tampilkanGambar(String pathFile) {
        try {
            if (pathFile == null || pathFile.isEmpty()) {
                imgPreview.setImage(null);
                return;
            }
            File file = new File(pathFile);
            if (file.exists()) {
                Image image = new Image(file.toURI().toString(), true);
                imgPreview.setImage(image);
            } else {
                imgPreview.setImage(null);
                System.out.println("File tidak ditemukan: " + pathFile);
            }
        } catch (Exception e) {
            imgPreview.setImage(null);
            System.err.println("Gagal memuat gambar: " + e.getMessage());
        }
    }

    private boolean validasiInput() {
        if (txtNama.getText().trim().isEmpty() ||
                txtTema.getText().trim().isEmpty() ||
                txtPathFile.getText().trim().isEmpty() ||
                cmbJenis.getValue() == null) {

            showWarning("Semua field harus diisi!");
            return false;
        }
        return true;
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.setTitle("Informasi");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
