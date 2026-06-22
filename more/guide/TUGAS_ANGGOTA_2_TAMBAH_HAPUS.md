# ➕ TUGAS ANGGOTA 2: Entry Point & Fitur Tambah/Hapus (Create & Delete)

**Peran:** Fullstack Developer (Fokus Insert/Delete & Inheritansi)
Porsi tugas ini mengatur jalan pintas awal aplikasi, serta fitur paling interaktif pertama yaitu menginput data baru dari form dan menghapus data. Kamu juga bertanggung jawab pada teori Pewarisan (Inheritance).

---

## 📖 Alur Logika Code (Penjelasan Saat Presentasi)

Saat presentasi, kamu bertugas menjelaskan bagaimana aplikasi ini mulai berjalan, bagaimana class anak mewarisi sifat dari induknya, dan proses Simpan/Hapus data.

1. **Bagian Model (Pilar PBO: Inheritansi/Pewarisan & Entry Point)**
   - **File:** `main/MainApp.java`, `model/FotoKamera.java`, `model/DesainVektor.java`
   - **Penjelasan Entry Point:** Menjelaskan bahwa `MainApp.java` adalah *start engine* aplikasi. Class ini yang me-load desain UI dan membukanya di window.
   - **Penjelasan Inheritansi:** Menjelaskan bahwa `FotoKamera` dan `DesainVektor` menggunakan kata kunci `extends AsetVisual`. Artinya, tanpa perlu mengetik ulang, mereka sudah mewarisi sifat `id`, `namaAset`, `tema`, dll dari induknya. Ini penerapan nyata dari **Inheritansi**.

2. **Bagian Database & DAO (Create & Delete)**
   - **File:** `dao/AsetVisualDAO.java`
   - **Penjelasan:** Menjelaskan isi method `insert()` dan `delete()`. 
   - Soroti bahwa aplikasi menggunakan `PreparedStatement` untuk mengeksekusi `INSERT INTO` dan `DELETE FROM`. Ini sangat penting karena mempermudah penyisipan variabel pakai tanda tanya `?` dan juga mencegah *Hacker* membobol database via *SQL Injection*.

3. **Bagian UI & Controller (Tombol Simpan & Hapus)**
   - **File:** `view/GaleriView.fxml` & `controller/GaleriController.java`
   - **Penjelasan:** 
     - Di FXML, kamu membuat kotak isian form menggunakan susunan `GridPane`.
     - Di `GaleriController.java`, jelaskan method `onSimpan()`: Method ini memvalidasi inputan (tidak boleh kosong), membungkus isian form menjadi sebuah objek, lalu mengirimnya ke DAO untuk di-insert ke database. Setelah sukses, panggil `loadData()` agar tabel langsung di-refresh.
     - Jelaskan method `onHapus()`: Saat tombol hapus ditekan, muncul *Alert* konfirmasi (Yes/No). Jika Yes, baris ID tersebut akan dikirim ke DAO untuk di-delete.

---

## 🎯 Panduan Tes Coding (Prediksi Soal Dosen)

Dosen biasanya akan menguji alur form dan database. Bersiaplah untuk:

1. **Ganti Judul Aplikasi:**
   - Dosen: *"Coba ubah judul window di bar atas aplikasi menjadi 'Ujian PBO'."*
   - Solusi: Buka `MainApp.java`, cari baris `primaryStage.setTitle("Manajemen Galeri Visual");`, dan ganti teksnya.

2. **Tambah Jenis Opsi ComboBox:**
   - Dosen: *"Tambahkan opsi 'Animasi 3D' di pilihan dropdown Jenis Aset."*
   - Solusi: Buka `GaleriController.java`, cari method `initialize()`, dan tambahkan `"Animasi 3D"` ke dalam `FXCollections.observableArrayList(...)`.

3. **Mengubah Pesan Pop-up (Alert):**
   - Dosen: *"Ubah teks notifikasi saat data sukses disimpan."*
   - Solusi: Buka `GaleriController.java`, cari method `onSimpan()`, lalu ubah teks di bagian `showInfo("Data berhasil disimpan.");`.

---

## 📂 Rekap Daftar File yang Dipegang
*(Pastikan kamu membuka dan memahami baris kode di file-file ini saat giliranmu)*
1. **`src/gallerees/main/MainApp.java`** (Fokus pada Entry point & ukuran window)
2. **`src/gallerees/model/FotoKamera.java` & `DesainVektor.java`** (Fokus pada kata kunci `extends` sebagai bukti Pewarisan)
3. **`src/gallerees/dao/AsetVisualDAO.java`** (Fokus pada method `insert` dan `delete`)
4. **`src/gallerees/view/GaleriView.fxml`** (Fokus pada susunan form `<GridPane>`, input `<TextField>`, dan `<Button>`)
5. **`src/gallerees/controller/GaleriController.java`** (Fokus pada method `onSimpan`, `onHapus`, dan `buatAsetDariForm`)
