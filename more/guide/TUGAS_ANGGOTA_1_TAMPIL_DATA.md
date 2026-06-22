# 📊 TUGAS ANGGOTA 1: Fondasi App & Fitur Tampil Data (Read)

**Peran:** Fullstack Developer (Fokus Read & Enkapsulasi)
Porsi tugas ini sangat krusial karena membangun kerangka awal aplikasi, koneksi database, dan memunculkan data ke layar. Kamu akan memegang semua lapisan kode (Model, Database, dan UI).

---

## 📖 Alur Logika Code (Penjelasan Saat Presentasi)

Saat presentasi, kamu bertugas menjelaskan bagaimana aplikasi bisa terhubung ke database dan menampilkan isinya ke dalam tabel.

1. **Bagian Model (Pilar PBO: Enkapsulasi)**
   - **File:** `model/AsetVisual.java`
   - **Penjelasan:** Menjelaskan bahwa class ini adalah "cetakan" data. Semua variabel (seperti `id`, `namaAset`, dll) dibuat `private` untuk melindungi data. Data ini hanya bisa diisi dan diambil menggunakan metode pembungkus yaitu **Getter dan Setter**. Ini adalah penerapan teori **Enkapsulasi**.

2. **Bagian Database & DAO (Koneksi & Read)**
   - **File:** `util/DatabaseConnection.java` & `dao/AsetVisualDAO.java`
   - **Penjelasan:** 
     - Menjelaskan bahwa `DatabaseConnection` adalah jembatan penghubung antara Java dan MySQL di Laragon.
     - Menjelaskan method `getAll()` di DAO. Di sini aplikasi mengirim perintah SQL `SELECT * FROM aset_visual`. Lalu data tersebut dibaca baris demi baris menggunakan `ResultSet` dan diubah menjadi *List* (daftar objek) yang siap dikirim ke tampilan.

3. **Bagian UI & Controller (Tabel Data)**
   - **File:** `view/GaleriView.fxml` & `controller/GaleriController.java`
   - **Penjelasan:** 
     - Menjelaskan desain kerangka `BorderPane` dan `TableView` di FXML.
     - Di `GaleriController.java`, jelaskan isi method `initialize()`. Di sana kolom tabel disambungkan ke variabel di Model menggunakan `PropertyValueFactory`. Setelah itu, method `loadData()` dipanggil untuk mengisi tabel tersebut dengan data dari database.

---

## 🎯 Panduan Tes Coding (Prediksi Soal Dosen)

Dosen biasanya akan menguji pemahaman di fitur yang kamu presentasikan. Bersiaplah untuk tantangan berikut:

1. **Ganti Nama Database:**
   - Dosen: *"Coba ubah koneksinya agar mengarah ke database bernama `db_ujian`."*
   - Solusi: Buka `DatabaseConnection.java`, ganti teks `javafxdb` di dalam link URL menjadi `db_ujian`.

2. **Ubah Judul Kolom di Tabel:**
   - Dosen: *"Coba ganti header tabel 'Nama Aset' menjadi 'Judul Karya'."*
   - Solusi: Buka `GaleriView.fxml`, cari `<TableColumn fx:id="colNama" text="Nama Aset".../>`, lalu ubah atribut `text` menjadi `"Judul Karya"`.

3. **Ubah Lebar Kolom Tabel:**
   - Dosen: *"Kolom ID terlalu kecil, coba besarkan jadi ukuran 100."*
   - Solusi: Buka `GaleriView.fxml`, cari `<TableColumn fx:id="colId"... prefWidth="50" />`, ganti `50` jadi `100`.

---

## 📂 Rekap Daftar File yang Dipegang
*(Pastikan kamu membuka dan memahami baris kode di file-file ini saat giliranmu)*
1. **`src/gallerees/model/AsetVisual.java`** (Fokus pada Enkapsulasi: Private variabel, Getter, & Setter)
2. **`src/gallerees/util/DatabaseConnection.java`** (Fokus pada URL database, Username, dan Password)
3. **`src/gallerees/dao/AsetVisualDAO.java`** (Fokus pada method `getAll` untuk query `SELECT *`)
4. **`src/gallerees/view/GaleriView.fxml`** (Fokus pada `<TableView>` dan `<TableColumn>`)
5. **`src/gallerees/controller/GaleriController.java`** (Fokus pada method `initialize` dan `loadData`)
