# ⚙️ TUGAS ANGGOTA 2: CRUD Layer Logika & Teori Inheritansi

**Peran:** Business Logic & Java Controller
Pada pembagian ini, **semua anggota kelompok ikut menjelaskan proses CRUD**, namun kamu mendapat jatah menjelaskan CRUD dari sudut pandang **Logika Controller** dan **Pewarisan (Inheritance)**. Kamu bertugas menjelaskan logika percabangan, validasi input, dan penghubung antara tombol UI dengan Database.

---

## 📖 Alur Penjelasan Saat Presentasi

Saat giliranmu bicara, fokuslah pada bagaimana aplikasi berpikir secara logika di belakang layar dan bagaimana class membagikan sifatnya.

### 1. Teori PBO: Inheritansi (Pewarisan)
- **Fokus File:** `model/FotoKamera.java` & `model/DesainVektor.java`
- **Penjelasan:** Jelaskan bahwa class `FotoKamera` dan `DesainVektor` adalah anak dari `AsetVisual`. Dengan menambahkan keyword `extends AsetVisual`, kedua anak ini otomatis "mewarisi" semua variabel (nama, tema, dll) tanpa perlu diketik ulang. Ini menghemat ratusan baris kode dan merupakan inti dari teori **Inheritansi**.

### 2. Penjelasan 4 Operasi CRUD dari sisi Controller (Logika Java)
- **Fokus File:** `controller/GaleriController.java`
- Di sini kamu menjelaskan apa yang terjadi di otak aplikasi (Controller) saat user menekan tombol CRUD.
- **C (Create) - `onSimpan()`:** Menjelaskan bahwa sebelum menyetorkan data ke DAO, sistem melakukan validasi (lewat method `validasiInput()`). Jika ada field yang kosong, CRUD digagalkan dan muncul *Warning*.
- **R (Read) - `loadData()`:** Menjelaskan bagaimana Controller mengambil array list dari DAO lalu menyuapkannya ke `TableView` agar muncul di layar.
- **U (Update) - `onUbah()`:** Menjelaskan bahwa sistem mengecek dulu, apakah user sudah meng-klik baris tabel? Jika belum, proses dibatalkan pakai *return*. Jika sudah, ambil ID-nya dan lempar ke DAO.
- **D (Delete) - `onHapus()`:** Menjelaskan bahwa sebelum menghapus, logika Controller akan memunculkan pop-up konfirmasi (Alert Yes/No) agar user tidak tidak sengaja menghapus data.

---

## 🎯 Panduan Tes Coding (Prediksi Soal Dosen)

Dosen biasanya akan menyuruhmu mengubah logika Java, memanipulasi pesan peringatan, atau menambah validasi.

1. **Pesan Validasi Spesifik (Bukan Pukul Rata):**
   - Dosen: *"Kalau yang kosong cuma textfield Nama Aset, pesannya jangan 'Semua field harus diisi', tapi harus 'Nama Aset wajib diisi!'."*
   - Solusi: Buka `GaleriController.java` method `validasiInput()`. Tambahkan logika IF khusus di atas pengecekan utama:
     ```java
     if (txtNama.getText().trim().isEmpty()) {
         showWarning("Nama Aset wajib diisi!");
         return false;
     }
     ```

2. **Memaksa Huruf Kapital saat Insert:**
   - Dosen: *"Setiap kali data disimpan, pastikan Nama Aset otomatis huruf besar semua (Kapital)."*
   - Solusi: Di method `buatAsetDariForm()`, pada bagian `String nama = txtNama.getText().trim();`, tambahkan `.toUpperCase()` menjadi `String nama = txtNama.getText().trim().toUpperCase();`.

---

## 📂 Rekap Daftar File yang Dipegang
*(Pastikan kamu mengerti baris kode di file-file ini sebelum presentasi)*
1. **`src/gallerees/model/FotoKamera.java` & `DesainVektor.java`** (Fokus pada kata kunci `extends` dan Constructor)
2. **`src/gallerees/controller/GaleriController.java`** (Fokus pada logika percabangan di `onSimpan()`, `onUbah()`, `onHapus()`, dan `validasiInput()`)
