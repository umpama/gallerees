# 🎨 TUGAS ANGGOTA 3: CRUD Layer UI & Teori Polimorfisme

**Peran:** UI/UX & Interactive Specialist
Pada pembagian ini, **semua anggota kelompok ikut menjelaskan proses CRUD**, namun kamu mendapat jatah menjelaskan CRUD dari sudut pandang **Tampilan (JavaFX FXML)**, **Interaksi User**, dan **Polimorfisme**. Kamu bertugas menjelaskan interaksi keren seperti klik baris tabel dan fitur *Browse* gambar.

---

## 📖 Alur Penjelasan Saat Presentasi

Saat giliranmu bicara, fokuslah pada bagaimana tombol, form, dan layar merespons aksi yang dilakukan user.

### 1. Teori PBO: Polimorfisme (Banyak Bentuk)
- **Fokus File:** `model/Manageable.java` (Interface) & Method `getJenis()`
- **Penjelasan:** Jelaskan bahwa `FotoKamera` dan `DesainVektor` sama-sama punya method `getJenis()` dan `tampilkanDetail()`, tapi kelakuannya berbeda saat dijalankan (satu nge-print "Foto Kamera", satu "Desain Vektor"). Ini terjadi karena *Override*. Fenomena di mana objek yang kembar tapi punya *skill* beda ini adalah penerapan nyata **Polimorfisme**.

### 2. Penjelasan 4 Operasi CRUD dari sisi UI (Tampilan)
- **Fokus File:** `view/GaleriView.fxml` & Interaksi Controller
- Di sini kamu menjelaskan elemen antarmuka yang membungkus seluruh CRUD.
- **C (Create) & U (Update) - Form Input:** Menjelaskan kode FXML `GridPane` yang mengatur posisi `TextField` dan `ComboBox`. Lalu fungsi tombol `<Button>` yang mengaitkan klik ke method controller (`onAction="#onSimpan"`).
- **R (Read) - Render Tabel:** Menjelaskan bagaimana `<TableView>` di FXML memunculkan data, dan bagaimana saat baris tabel diklik, *Listener* otomatis membaca baris itu untuk memunculkan **Image Preview** di layar.
- **Interaksi Fitur Browse (File Explorer):** Menjelaskan method `onBrowsePath()` di Controller. Fitur ini menggunakan class `FileChooser` bawaan JavaFX untuk membuka popup File Explorer, lalu menyedot path gambar (`.png`, `.jpg`) agar user tidak perlu repot mengetik path secara manual.

---

## 🎯 Panduan Tes Coding (Prediksi Soal Dosen)

Dosen sangat suka mengubah tampilan visual, jadi persiapkan dirimu untuk soal-soal UI:

1. **Ubah Warna Background Header / Tombol:**
   - Dosen: *"Ubah tombol Bersihkan form yang abu-abu jadi warna ungu."*
   - Solusi: Buka `GaleriView.fxml`, cari `<Button fx:id="btnBersihkan"... style="-fx-background-color: #6c757d; ...">`, ganti warnanya dari `#6c757d` menjadi `#8a2be2` (ungu).

2. **Matikan Fitur Klik Baris Tabel:**
   - Dosen: *"Coba non-aktifkan fitur klik tabel. Jadi kalau tabel diklik, gambarnya jangan muncul."*
   - Solusi: Buka `GaleriController.java`, cari bagian method `initialize()`, lalu beri komentar ganda (`//`) di depan blok kode mulai dari `tabelAset.getSelectionModel().selectedItemProperty().addListener(...` sampai tutup kurungnya.

3. **Ubah Placeholder (Teks Kosong) di Tabel:**
   - Dosen: *"Kalau tabel datanya kosong (database di-clear), saya mau tulisannya bukan 'Belum ada data' tapi 'Database Galeri Masih Kosong!'."*
   - Solusi: Buka `GaleriView.fxml`, cari tag `<placeholder><Label text="Belum ada data. Silakan tambahkan aset baru." /></placeholder>`. Ubah teksnya di situ.

---

## 📂 Rekap Daftar File yang Dipegang
*(Pastikan kamu mengerti baris kode di file-file ini sebelum presentasi)*
1. **`src/gallerees/model/Manageable.java`** (Penjelasan Interface & Polimorfisme)
2. **`src/gallerees/view/GaleriView.fxml`** (Fokus pada desain form `<GridPane>`, tabel `<TableView>`, dan `<Button>`)
3. **`src/gallerees/controller/GaleriController.java`** (Fokus pada method `onBrowsePath()`, `tampilkanGambar()`, dan Listener klik tabel)
