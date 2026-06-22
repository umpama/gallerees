# 📘 Setup Guide — Proyek Gallerees (Manajemen Galeri Visual)

> Panduan lengkap untuk mengonfigurasi dan menjalankan proyek JavaFX + MySQL dari VS Code.

---

## 📋 Daftar Isi

1. [Prasyarat](#-1-prasyarat)
2. [Struktur Proyek](#-2-struktur-proyek)
3. [Setup Laragon & MySQL](#-3-setup-laragon--mysql)
4. [Konfigurasi VS Code](#-4-konfigurasi-vs-code)
5. [Menjalankan Aplikasi (F5)](#-5-menjalankan-aplikasi-f5)
6. [Troubleshooting](#-6-troubleshooting)

---

## 🔧 1. Prasyarat

| Komponen | Versi | Lokasi |
|----------|-------|--------|
| **JDK** | Oracle JDK 26.0.1 (Scoop) | Sudah di PATH |
| **OpenJFX SDK** | 26.0.1 (Windows x64) | `more/openjfx-.../javafx-sdk-26.0.1/` |
| **MySQL Connector/J** | 9.7.0 | `more/mysql-connector-j-9.7.0/.../` |
| **Laragon** | Versi terbaru | Untuk MySQL lokal |
| **VS Code Extension** | Extension Pack for Java | Wajib install |

---

## 📂 2. Struktur Proyek

```
gallerees/
├── .classpath                 ← Konfigurasi JDT (module path)
├── .project                   ← Konfigurasi Eclipse/JDT
├── .vscode/
│   ├── launch.json            ← Konfigurasi F5 Debug
│   └── settings.json          ← Konfigurasi VS Code Java
├── SETUP_GUIDE.md             ← File ini
├── more/                      ← Library eksternal
│   ├── openjfx-26.0.1_.../
│   │   └── javafx-sdk-26.0.1/lib/
│   └── mysql-connector-j-9.7.0/
│       └── .../mysql-connector-j-9.7.0.jar
├── src/
│   ├── module-info.java
│   └── gallerees/
│       ├── main/
│       │   └── MainApp.java          ← Entry point
│       ├── util/
│       │   └── DatabaseConnection.java
│       ├── model/
│       │   ├── Manageable.java        ← Interface
│       │   ├── AsetVisual.java        ← Abstract Class
│       │   ├── FotoKamera.java        ← Child Class
│       │   └── DesainVektor.java      ← Child Class
│       ├── dao/
│       │   └── AsetVisualDAO.java     ← CRUD
│       ├── controller/
│       │   └── GaleriController.java  ← FXML Controller
│       └── view/
│           └── GaleriView.fxml        ← UI Layout
└── bin/                               ← Hasil build (auto-generated)
```

---

## 🐬 3. Setup Laragon & MySQL

### 3.1 Buka Laragon

1. Buka **Laragon**
2. Klik tombol **"Start All"** (atau pastikan MySQL saja yang aktif)
3. Pastikan indikator MySQL berwarna **hijau** ✅

### 3.2 Buka Terminal MySQL

Klik **Menu** → **MySQL** → **Console** di Laragon, atau buka terminal:

```bash
mysql -u root
```

> Password default Laragon adalah **kosong** (langsung tekan Enter).

### 3.3 Buat Database & Tabel

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
```

### 3.4 (Opsional) Insert Data Contoh

```sql
INSERT INTO aset_visual (nama_aset, tema, jenis, path_file) VALUES
('Sunset Beach', 'Landscape', 'Foto Kamera', 'C:/images/sunset.jpg'),
('Logo Startup', 'Branding', 'Desain Vektor', 'C:/images/logo.svg');
```

### 3.5 Verifikasi

```sql
SELECT * FROM aset_visual;
```

Kalau muncul data, database siap! ✅

---

## ⚙️ 4. Konfigurasi VS Code

### 4.1 Install Extension (Wajib)

Buka VS Code → Extensions (`Ctrl+Shift+X`) → Install:
- **Extension Pack for Java** (by Microsoft)

Extension ini otomatis install: Language Support, Debugger, Maven, dll.

### 4.2 Clean Language Server (PENTING!)

Setelah buka proyek, **wajib clean dulu** agar VS Code baca konfigurasi `.classpath` dan `.project`:

1. Tekan `Ctrl+Shift+P`
2. Ketik: **"Java: Clean Java Language Server Workspace"**
3. Klik → Pilih **"Restart and delete"**
4. Tunggu VS Code restart dan loading selesai (lihat status bar kiri bawah)

> ⏳ Proses loading pertama kali bisa 30-60 detik. Tunggu sampai status bar menunjukkan "Ready".

### 4.3 Verifikasi — Kode Tidak Merah Lagi

Setelah restart:
- Buka `module-info.java` → `requires javafx.controls` harus **tidak merah**
- Buka `GaleriController.java` → semua import harus **tidak merah**
- Buka `MainApp.java` → semua import harus **tidak merah**

Kalau masih merah, coba:
1. `Ctrl+Shift+P` → **"Java: Clean Java Language Server Workspace"** (ulangi)
2. Pastikan JDK terdeteksi: `Ctrl+Shift+P` → **"Java: Configure Java Runtime"** → pastikan JDK 26.0.1 terpilih

---

## 🚀 5. Menjalankan Aplikasi (F5)

### Cara 1: Tekan F5

1. Pastikan **Laragon MySQL sudah running** ✅
2. Buka file `MainApp.java`
3. Tekan **F5** (atau klik **Run → Start Debugging**)
4. Pilih konfigurasi **"Launch Gallerees"**
5. Aplikasi akan muncul! 🎉

### Cara 2: Klik Run di MainApp.java

1. Buka `MainApp.java`
2. Klik tombol **"Run"** atau **"Debug"** yang muncul di atas method `main()`
3. Aplikasi langsung jalan

### Cara Pakai Aplikasi

| Aksi | Cara |
|------|------|
| Tambah data | Isi form → klik **Simpan** |
| Edit data | Klik baris tabel → ubah form → klik **Ubah** |
| Hapus data | Klik baris tabel → klik **Hapus** → Konfirmasi |
| Preview gambar | Klik baris tabel → gambar muncul di panel kanan |
| Reset form | Klik **Bersihkan** |

> Untuk Path File, gunakan format: `C:/images/foto.jpg` (forward slash).

---

## 🛠️ 6. Troubleshooting

### ❌ Kode masih merah setelah clean workspace

1. Pastikan file `.classpath` dan `.project` ada di **root folder** proyek
2. Pastikan **Extension Pack for Java** terinstall
3. Coba: `Ctrl+Shift+P` → **"Developer: Reload Window"**
4. Cek JDK: `Ctrl+Shift+P` → **"Java: Configure Java Runtime"**

---

### ❌ Error: "JavaFX runtime components are missing"

Pastikan `launch.json` sudah ada dan `vmArgs` benar. Konfigurasi sudah disediakan otomatis.

---

### ❌ Error: "Communications link failure" / Tidak bisa konek DB

1. Buka Laragon → Klik **Start All**
2. Pastikan port MySQL = **3306**
3. Pastikan database `javafxdb` sudah dibuat (lihat Step 3)

---

### ❌ Error: "No suitable driver" / MySQL tidak terdeteksi

Pastikan `mysql-connector-j-9.7.0.jar` ada di `.classpath` dengan `module="true"`.

---

### ❌ Gambar tidak muncul di ImageView

- Path harus valid dan file harus ada: `C:/images/nama_file.jpg`
- Format yang didukung: `.jpg`, `.jpeg`, `.png`, `.gif`, `.bmp`

---

## 📌 Quick Reference

| Aksi | Shortcut/Perintah |
|------|--------------------|
| Run/Debug | **F5** di VS Code |
| Clean LS | `Ctrl+Shift+P` → "Java: Clean Java Language Server Workspace" |
| Masuk MySQL | `mysql -u root` (di Laragon Console) |
| Buat Database | `CREATE DATABASE javafxdb;` |
| Reload Window | `Ctrl+Shift+P` → "Developer: Reload Window" |

---

*Setup guide ini dibuat untuk proyek Tugas Besar PBO — D3 Sistem Informasi.*
