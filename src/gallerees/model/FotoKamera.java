package gallerees.model;

/**
 * polimorfisme
 */
public class FotoKamera extends AsetVisual {

    public FotoKamera() {
    }

    public FotoKamera(int id, String namaAset, String tema, String pathFile) {
        super(id, namaAset, tema, pathFile);
    }

    @Override
    public String getJenis() {
        return "Foto Kamera";
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("===== Detail Foto Kamera =====");
        System.out.println("ID        : " + getId());
        System.out.println("Nama Aset : " + getNamaAset());
        System.out.println("Tema      : " + getTema());
        System.out.println("Jenis     : " + getJenis());
        System.out.println("Path File : " + getPathFile());
        System.out.println("==============================");
    }
}
