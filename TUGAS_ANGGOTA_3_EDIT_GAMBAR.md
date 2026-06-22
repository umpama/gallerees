# 🖼️ TUGAS ANGGOTA 3: Fitur Edit, Preview Gambar & Polimorfisme

**Peran:** Fullstack Developer (Fokus Update, Interaktivitas UI, & Polimorfisme)
Porsi tugas ini adalah bagian yang paling *"Wow"* dari aplikasi, yaitu fitur memilih/menampilkan gambar dan membedakan perilaku objek. Kamu memegang kendali atas update data dan interaksi kompleks di UI.

---

## 📖 Alur Logika Code (Penjelasan Saat Presentasi)

Saat presentasi, kamu bertugas menjelaskan tentang fitur Ubah (Update), cara gambar bisa muncul dari File Explorer, dan bagaimana sistem membedakan objek secara cerdas.

1. **Bagian Model (Pilar PBO: Polimorfisme & Abstraksi)**
   - **File:** `model/Manageable.java` (Interface) & `model/AsetVisual.java`
   - **Penjelasan Abstraksi:** Interface `Manageable` adalah "kontrak" yang memaksa turunannya untuk memiliki method `tampilkanDetail()`.
   - **Penjelasan Polimorfisme:** Meski `FotoKamera` dan `DesainVektor` berasal dari turunan yang sama, namun ketika method `getJenis()` atau `tampilkanDetail()` dipanggil, hasil yang keluar akan berbeda sesuai jenis objeknya masing-masing. Mereka menimpa (*Override*) kelakuan asli si induk. Inilah penerapan **Polimorfisme** (Banyak Bentuk).

2. **Bagian Database & DAO (Update Data)**
   - **File:** `dao/AsetVisualDAO.java`
   - **Penjelasan:** Menjelaskan method `update()`. Saat diklik "Ubah", sistem akan mengeksekusi query `UPDATE aset_visual SET ... WHERE id = ?`. Data yang lama akan ditimpa dengan data baru dari form sesuai dengan ID yang dipilih.

3. **Bagian UI & Controller (Fitur Browse File & Klik Tabel)**
   - **File:** `view/GaleriView.fxml` & `controller/GaleriController.java`
   - **Penjelasan `onUbah()`:** Hampir sama dengan Simpan, namun ini membutuhkan data yang sedang dipilih (di-klik) di tabel. Setelah form diedit dan diklik "Ubah", data tersebut diperbarui.
   - **Penjelasan `onBrowsePath()`:** Menjelaskan fitur *Browse* (Tombol Pilih...). Logika ini menggunakan `FileChooser` JavaFX untuk membuka File Explorer Windows, memfilter tipe file menjadi gambar saja, mengambil path (*lokasi*) gambar tersebut, dan mencetaknya ke kolom teks.
   - **Penjelasan Klik Tabel & `tampilkanGambar()`:** Ketika sebuah baris di tabel diklik, *Listener* di controller akan merespons. Dia mengambil path file, mengubahnya jadi format `Image`, lalu memasukkannya ke dalam elemen `ImageView` secara instan!

---

## 🎯 Panduan Tes Coding (Prediksi Soal Dosen)

Dosen sangat menyukai hal-hal yang berbau visual. Bersiaplah untuk:

1. **Ubah Warna Tombol:**
   - Dosen: *"Coba ubah warna tombol 'Pilih...' jadi warna hijau / biru."*
   - Solusi: Buka `GaleriView.fxml`, cari `<Button text="Pilih..." ... style="-fx-background-color: #e9ecef; ...">`, ganti hex color `#e9ecef` ke kode warna baru (misal: `green` atau `#28a745`).

2. **Modifikasi Logika Validasi (Wajib Isi):**
   - Dosen: *"Kalau teks 'Path File' nya kosong saat mau Disimpan/Diubah, saya mau pesannya bukan 'Semua field harus diisi', tapi harus spesifik 'Gak boleh upload tanpa gambar!'."*
   - Solusi: Buka `GaleriController.java`, ubah method `validasiInput()`. Tambahkan logika khusus:
     ```java
     if (txtPathFile.getText().trim().isEmpty()) {
         showWarning("Gak boleh upload tanpa gambar!");
         return false;
     }
     ```

3. **Ubah Filter File Explorer:**
   - Dosen: *"Coba ubah tombol Pilih... supaya hanya bisa membuka ekstensi '.png' saja."*
   - Solusi: Buka `GaleriController.java`, di dalam method `onBrowsePath()`, hapus `*.jpg`, `*.jpeg` dll pada baris `new FileChooser.ExtensionFilter(...)` sisakan hanya `"*.png"`.

---

## 📂 Rekap Daftar File yang Dipegang
*(Pastikan kamu membuka dan memahami baris kode di file-file ini saat giliranmu)*
1. **`src/gallerees/model/Manageable.java`** (Fokus pada fungsi Interface)
2. **`src/gallerees/model/AsetVisual.java`** (Fokus pada method `abstract getJenis()`)
3. **`src/gallerees/dao/AsetVisualDAO.java`** (Fokus pada method `update` / `UPDATE aset_visual SET...`)
4. **`src/gallerees/view/GaleriView.fxml`** (Fokus pada tombol Ubah, tombol Pilih, dan `<ImageView>`)
5. **`src/gallerees/controller/GaleriController.java`** (Fokus pada method `onUbah`, `onBrowsePath`, `tampilkanGambar`, dan listener klik tabel)
