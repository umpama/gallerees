# 🗄️ TUGAS ANGGOTA 1: Database & Data Access Object (DAO)

**Peran:** Backend & Database Engineer
**Fokus File:**
1. `src/gallerees/util/DatabaseConnection.java`
2. `src/gallerees/dao/AsetVisualDAO.java`

---

## 📖 Alur Logika Code (Penjelasan Saat Presentasi)

Bagian ini bertanggung jawab murni pada komunikasi antara aplikasi Java dengan Database MySQL.

1. **DatabaseConnection.java (Koneksi Database)**
   - **Fungsi:** Menyediakan jembatan/koneksi ke MySQL yang jalan di Laragon.
   - **Alur:** Menggunakan URL `jdbc:mysql://localhost:3306/javafxdb` dengan user `root` dan tanpa password. Class ini punya method static `getConnection()` yang akan dipanggil setiap kali butuh ngobrol sama database.

2. **AsetVisualDAO.java (CRUD Logic)**
   - **Fungsi:** Mengelola query SQL (Create, Read, Update, Delete). DAO (*Data Access Object*) adalah tempat di mana sintaks SQL berada, jadi di luar file ini tidak boleh ada sintaks SQL (untuk menjaga kode tetap bersih).
   - **Alur Insert / Update / Delete:** Menggunakan `PreparedStatement` untuk mengeksekusi query. Ini sangat penting karena `PreparedStatement` mencegah bahaya *SQL Injection* (serangan hacker) dan memudahkan kita masukin variabel ke tanda tanya `?` di string SQL.
   - **Alur Read (getAll):**
     - Menggunakan `ResultSet` untuk membaca baris demi baris dari tabel `aset_visual`.
     - **Poin Penting (Polimorfisme saat Read):** Waktu data ditarik, kode akan mengecek kolom `jenis`. Kalau nilainya `"Desain Vektor"`, maka dia akan diinstansiasi menjadi objek `new DesainVektor()`. Kalau tidak, maka jadi `new FotoKamera()`. Objek-objek ini lalu dimasukkan ke dalam `List<AsetVisual>` dan dikembalikan ke Controller untuk ditampilkan di tabel.

---

## 🎯 Panduan Tes Coding (Apa yang Mungkin Ditanyakan Dosen)

Dosen biasanya menguji pemahaman tentang database di bagian ini. Bersiaplah untuk:

1. **Ganti Nama Database / Tabel:**
   - Dosen: *"Coba ganti aplikasi ini biar nyambung ke database bernama `db_tugas`."*
   - Solusi: Buka `DatabaseConnection.java`, ubah tulisan `javafxdb` di URL menjadi `db_tugas`.

2. **Menambah Kolom Baru (Misal: Tanggal / Deskripsi):**
   - Dosen: *"Tambahkan fitur untuk menyimpan `deskripsi` aset ke dalam database."*
   - Solusi: 
     - Tambah kolom di MySQL via phpMyAdmin.
     - Buka `AsetVisualDAO.java`, ubah query `INSERT INTO` dan `UPDATE` (tambah 1 parameter `?`), lalu set nilainya menggunakan `ps.setString(..., aset.getDeskripsi())`.
     - Di method `getAll()`, tambahkan `String desk = rs.getString("deskripsi");` lalu masukkan ke objek saat di-new.

3. **Ganti Password:**
   - Dosen: *"Kalau database saya dikasih password 'rahasia', di mana gantinya?"*
   - Solusi: Buka `DatabaseConnection.java`, ubah variabel `PASS = ""` menjadi `PASS = "rahasia"`.
