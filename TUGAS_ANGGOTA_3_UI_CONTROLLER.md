# 🎨 TUGAS ANGGOTA 3: Antarmuka (View) & Kontroler (Controller)

**Peran:** Frontend (JavaFX) & UI Logic
**Fokus File:**
1. `src/gallerees/view/GaleriView.fxml` (Desain UI)
2. `src/gallerees/controller/GaleriController.java` (Logika UI)

---

## 📖 Alur Logika Code (Penjelasan Saat Presentasi)

Bagian ini adalah apa yang dilihat oleh user (tampilan) dan bagaimana aplikasi merespon klik dari user.

1. **GaleriView.fxml (XML Markup)**
   - **Fungsi:** Mengatur tata letak / layout tampilan.
   - **Alur:** 
     - Menggunakan `BorderPane` untuk membagi layar atas (Judul), tengah (Tabel), dan bawah (Form Input + Preview Gambar).
     - Menggunakan `GridPane` supaya form input (label dan kotak isian) bisa rapi berbaris.
     - Terdapat tombol `Pilih...` yang fungsinya memanggil method `#onBrowsePath` untuk membuka File Explorer.
   
2. **GaleriController.java (Otak Tampilan)**
   - **Fungsi:** Menyambungkan apa yang ada di FXML dengan database (melalui DAO) dan class Model.
   - **Annotation `@FXML`:** Tanda ini wajib ada di depan nama variabel agar terhubung dengan `fx:id` yang ada di FXML.
   - **Alur `initialize()`:** Ini adalah method yang dipanggil otomatis pertama kali aplikasi jalan. Di sini kita ngatur pilihan ComboBox, mengikat nama variabel di class ke kolom tabel (`PropertyValueFactory`), ngambil data awal dari database (`loadData()`), dan ngasih "telinga" (*Listener*) ke tabel biar mendeteksi kalau diklik.
   - **Alur CRUD (`onSimpan`, `onUbah`, dll):** Saat diklik, controller akan baca isian di text field, bikin objek Model, nge-lempar objek itu ke `dao.insert()`, lalu kosongin form dan me-refresh tabel.
   - **Alur Menampilkan Gambar (`onBrowsePath` & `tampilkanGambar`):**
     - Pakai `FileChooser` untuk membuka popup File Explorer bawaan Windows.
     - Kalau diklik tabelnya, controller ambil string `pathFile`, dijadiin objek `File`, lalu diubah jadi `Image` untuk dimasukin ke kotak `ImageView`. Semua dibungkus `try-catch` biar kalau path-nya error/gambarnya ilang, aplikasi nggak crash.

---

## 🎯 Panduan Tes Coding (Apa yang Mungkin Ditanyakan Dosen)

Dosen biasanya menguji logika UI dan cara merubah tampilan. Bersiaplah untuk:

1. **Ubah Alert / Pesan Pop-up:**
   - Dosen: *"Coba ubah tulisan konfirmasi saat menghapus data."*
   - Solusi: Cari method `onHapus()`, ubah string di dalam `new Alert(..., "Yakin ingin menghapus...")` menjadi teks yang diinginkan.

2. **Menambah Validasi Form Kosong:**
   - Dosen: *"Gimana caranya supaya kalau cuma 'Tema' yang kosong, tulisannya bukan 'Semua field harus diisi' tapi 'Tema wajib diisi!'?"*
   - Solusi: Edit method `validasiInput()`. Tambahkan logika `if (txtTema.getText().isEmpty()) { showWarning("Tema wajib diisi!"); return false; }`.

3. **Nambah Field Input di Tampilan:**
   - Dosen: *"Tambah satu textfield untuk 'Tahun' di bawah Tema."*
   - Solusi: 
     - Buka `GaleriView.fxml`. Tambahkan `<Label>` dan `<TextField>` baru di dalam `<GridPane>` pada `rowIndex` berikutnya.
     - Buka `GaleriController.java`. Tambahkan `@FXML private TextField txtTahun;`.

4. **Ubah Warna Tombol:**
   - Dosen: *"Ganti warna tombol 'Simpan' jadi warna Hijau."*
   - Solusi: Buka `GaleriView.fxml`, cari `<Button fx:id="btnSimpan" ... style="-fx-background-color: #4568dc; ...">`, ganti `#4568dc` menjadi warna hijau misal `#28a745`.
