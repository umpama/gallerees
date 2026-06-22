# 🚀 Setup Guide Lengkap (Khusus Anggota Kelompok)

> Panduan ini dibuat khusus untuk anggota kelompok yang **belum pernah install apa-apa**. Tinggal ikuti langkah-langkah di bawah ini secara berurutan, dan project langsung bisa di-run!

---

## 📥 1. Download & Install Software Wajib

Kalian butuh 3 software utama. Download dan install semuanya:

### A. Java Development Kit (JDK)
Karena kita pakai Java versi baru, kalian harus install minimal **JDK 21** atau **JDK 22**.
- **Download:** [Temurin OpenJDK (Adoptium)](https://adoptium.net/) atau [Oracle JDK](https://www.oracle.com/java/technologies/downloads/).
- **Cara Install:** Buka file `.msi` atau `.exe` yang di-download, tinggal *Next-Next* aja. 
- **PENTING:** Saat proses instalasi (terutama kalau pakai Adoptium/Temurin), pastikan opsi **"Set JAVA_HOME variable"** disilang merah diubah jadi **"Will be installed on local hard drive"**. Ini biar Java otomatis masuk ke sistem Windows.

### B. Visual Studio Code (VS Code)
- **Download:** [code.visualstudio.com](https://code.visualstudio.com/)
- **Cara Install:** Install biasa seperti biasa.

### C. Laragon (Untuk Database MySQL)
- **Download:** [Laragon Full / Lite](https://laragon.org/download/)
- **Cara Install:** Install biasa. Setelah selesai, buka Laragon dan klik tombol **Start All**.

---

## ⚙️ 2. Konfigurasi VS Code & Project

Karena file JavaFX dan MySQL Connector sudah *include* (dibawa) di dalam folder `more/` pada project ini, **kalian nggak perlu repot download library tambahan lagi!**

### Langkah-langkah:

1. **Buka Project:** Buka VS Code, klik `File` -> `Open Folder`, lalu pilih folder project `gallerees` ini.
2. **Install Extension Java:** 
   - Di VS Code, tekan tombol `Ctrl + Shift + X` (buka tab Extensions).
   - Cari dan install extension bernama **Extension Pack for Java** (buatan Microsoft).
3. **Tunggu Loading:** Setelah install extension, tunggu sebentar. Di pojok kanan bawah akan ada tulisan *Loading Java Workspace* atau icon loading muter-muter. Tunggu sampai selesai (ada icon jempol/ceklis).

### 🛠️ Mengatasi Kode Merah (SANGAT PENTING!)
Supaya VS Code tahu kalau project ini pakai library JavaFX dan MySQL yang ada di folder `more/`, lakukan langkah ini:
1. Tekan kombinasi tombol **`Ctrl + Shift + P`** di keyboard.
2. Ketik: **`Java: Clean Java Language Server Workspace`** lalu tekan Enter.
3. Akan muncul peringatan, pilih **"Restart and delete"**.
4. VS Code akan refresh. Tunggu sampai loading di kiri bawah selesai. Semua kode yang tadinya merah-merah akan otomatis jadi normal! ✅

---

## 🐬 3. Bikin Database di Laragon

Project ini pakai database, jadi kita harus bikin *wadah* databasenya dulu di laptop masing-masing.

1. Buka aplikasi **Laragon**, pastikan sudah klik **Start All** (indikator MySQL warna Hijau).
2. Klik menu **Database** di Laragon. Nanti akan otomatis buka **phpMyAdmin** atau **HeidiSQL**.
3. Buka tab **Query** atau **SQL**.
4. Copy-Paste kode SQL di bawah ini, lalu klik **Go / Run / Execute**:

```sql
CREATE DATABASE IF NOT EXISTS javafxdb;

USE javafxdb;

CREATE TABLE IF NOT EXISTS aset_visual (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama_aset VARCHAR(100),
    tema VARCHAR(100),
    jenis VARCHAR(50),
    path_file VARCHAR(255)
);

-- Masukin data dummy buat ngetes:
INSERT INTO aset_visual (nama_aset, tema, jenis, path_file) VALUES
('Sunset Beach', 'Landscape', 'Foto Kamera', 'C:/images/sunset.jpg');
```

---

## 🏃‍♂️ 4. Cara Nge-Run (Jalanin Aplikasi)

Kalau step 1 sampai 3 udah beres, jalankan aplikasinya gampang banget:

1. Di VS Code, buka folder `src/gallerees/main/` lalu klik file **`MainApp.java`**.
2. Cukup tekan tombol **`F5`** di keyboard, atau klik tombol tulisan **"Run"** kecil yang ada persis di atas tulisan `public static void main(String[] args)`.
3. Tunggu sedetik, dan **BOOOM!** Aplikasi Manajemen Galeri Visual kalian jalan. 🎉

### Kenapa Gagal Run / Error?
- *Error: Communications link failure* 👉 Laragon / MySQL-nya belum dinyalain.
- *Error: JavaFX runtime components are missing* 👉 Kalian lupa ngelakuin step **2.🛠️ (Clean Java Workspace)** di atas.
- *Tidak bisa nemu database* 👉 Kalian belum jalanin query SQL di step 3.
