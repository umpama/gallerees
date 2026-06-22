# 🗄️ TUGAS ANGGOTA 1: CRUD Layer Data & Teori Enkapsulasi

**Peran:** Data & Storage Architect
Pada pembagian ini, **semua anggota kelompok ikut menjelaskan proses CRUD**, namun kamu mendapat jatah menjelaskan CRUD dari sudut pandang **Database (SQL)** dan keamanan data (**Enkapsulasi**). Kamu bertugas meyakinkan dosen bahwa aplikasi ini aman dan tersimpan dengan benar di database.

---

## 📖 Alur Penjelasan Saat Presentasi

Saat giliranmu bicara, fokuslah pada bagaimana Java mengirim data ke MySQL dan bagaimana data dibungkus agar aman.

### 1. Teori PBO: Enkapsulasi (Pembungkus Data)
- **Fokus File:** `model/AsetVisual.java`
- **Penjelasan:** Jelaskan bahwa sebelum data dikirim ke database, data dibungkus dulu ke dalam class `AsetVisual`. Semua variabel (seperti `id`, `namaAset`, `pathFile`) dibuat berstatus `private` agar tidak bisa diubah sembarangan oleh file lain (mencegah error/hacker). Untuk mengisi atau mengambil datanya, kita menggunakan method pelindung yang disebut **Getter dan Setter**. Ini adalah penerapan mutlak dari teori **Enkapsulasi**.

### 2. Penjelasan 4 Operasi CRUD dari sisi Database (SQL)
- **Fokus File:** `dao/AsetVisualDAO.java`
- Di sini kamu menjelaskan bahwa seluruh eksekusi CRUD menggunakan `PreparedStatement` yang mengamankan aplikasi dari serangan *SQL Injection*.
- **C (Create) - `insert()`:** Menjelaskan cara Java mengeksekusi string `INSERT INTO aset_visual...`. Variabel dari form disisipkan ke tanda tanya `?` menggunakan `ps.setString()`.
- **R (Read) - `getAll()`:** Menjelaskan query `SELECT * FROM aset_visual`. Data diambil baris per baris menggunakan `ResultSet` dan dikembalikan ke layar.
- **U (Update) - `update()`:** Menjelaskan query `UPDATE aset_visual SET nama_aset = ? ... WHERE id = ?`. Data lama ditimpa berdasarkan `id`.
- **D (Delete) - `delete()`:** Menjelaskan query `DELETE FROM aset_visual WHERE id = ?`.

---

## 🎯 Panduan Tes Coding (Prediksi Soal Dosen)

Dosen pasti akan menyuruhmu mengotak-atik query SQL atau menambah data baru.

1. **Ganti Nama Database / Ganti Password:**
   - Dosen: *"Coba hubungkan aplikasi ini ke database bernama 'ujian_pbo' yang ada passwordnya '1234'."*
   - Solusi: Buka `util/DatabaseConnection.java`, ganti teks `javafxdb` di dalam link URL menjadi `ujian_pbo`. Lalu ubah `PASS = ""` menjadi `PASS = "1234"`.

2. **Cegah Delete ID Tertentu:**
   - Dosen: *"Coba ubah query hapusnya supaya ID nomor 1 tidak akan pernah bisa dihapus."*
   - Solusi: Buka `AsetVisualDAO.java` di method `delete()`. Ubah query string-nya menjadi:  
     `"DELETE FROM aset_visual WHERE id = ? AND id != 1"`

---

## 📂 Rekap Daftar File yang Dipegang
*(Pastikan kamu mengerti baris kode di file-file ini sebelum presentasi)*
1. **`src/gallerees/model/AsetVisual.java`** (Bagian variabel private dan Getter/Setter)
2. **`src/gallerees/util/DatabaseConnection.java`** (Semua isi file ini)
3. **`src/gallerees/dao/AsetVisualDAO.java`** (Semua operasi SQL CRUD: Insert, GetAll, Update, Delete)
