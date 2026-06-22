# 🏗️ TUGAS ANGGOTA 2: Konsep OOP (Model) & Arsitektur Utama

**Peran:** System Architect & OOP Specialist
**Fokus File:**
1. `src/gallerees/main/MainApp.java`
2. `src/gallerees/model/Manageable.java` (Interface)
3. `src/gallerees/model/AsetVisual.java` (Abstract Class)
4. `src/gallerees/model/FotoKamera.java` & `DesainVektor.java` (Child Class)

---

## 📖 Alur Logika Code (Penjelasan Saat Presentasi)

Bagian ini adalah otak dari penerapan Teori PBO (Pemrograman Berorientasi Objek). Harus paham 4 pilar utama OOP!

1. **MainApp.java (Entry Point)**
   - **Fungsi:** Menjadi pintu masuk pertama aplikasi saat di-run.
   - **Alur:** Me-load file tampilan `GaleriView.fxml`, membungkusnya ke dalam `Scene`, memberi judul window, mengatur ukuran, dan menampilkannya di `Stage` (layar utama).

2. **Manageable.java (Abstraksi - Interface)**
   - **Fungsi:** Sebuah "kontrak" wajib. Class manapun yang meng-implements interface ini, diwajibkan untuk memiliki method `tampilkanDetail()`.

3. **AsetVisual.java (Enkapsulasi & Abstraksi - Parent Class)**
   - **Fungsi:** Induk / Template dasar untuk semua jenis aset.
   - **Alur Enkapsulasi:** Semua variabel (`id`, `namaAset`, dll) dibuat `private`. Akses ke variabel tersebut dilindungi dan hanya bisa diedit lewat method `Getter` dan `Setter`.
   - **Alur Abstraksi:** Class ini dideklarasikan sebagai `abstract`, artinya kita tidak boleh membuat objek langsung dengan `new AsetVisual()`. Dia juga memiliki *abstract method* `getJenis()` yang sengaja dikosongkan agar wajib diisi oleh turunannya.

4. **FotoKamera & DesainVektor (Inheritance & Polimorfisme)**
   - **Alur Inheritance (Pewarisan):** Keduanya menggunakan keyword `extends AsetVisual`. Artinya mereka mewarisi semua variabel dan getter/setter dari induknya tanpa perlu diketik ulang.
   - **Alur Polimorfisme (Banyak Bentuk):** Keduanya menerapkan *Method Overriding* pada method `getJenis()` dan `tampilkanDetail()`. Walaupun nama method-nya sama, perilakunya berbeda. `FotoKamera` akan mengembalikan String "Foto Kamera", sedangkan `DesainVektor` akan mengembalikan "Desain Vektor". 

---

## 🎯 Panduan Tes Coding (Apa yang Mungkin Ditanyakan Dosen)

Dosen biasanya menguji 4 pilar OOP di sini. Bersiaplah untuk:

1. **Membuat Jenis Aset Baru:**
   - Dosen: *"Coba tambahkan jenis aset baru, misalnya `VideoAnimasi`."*
   - Solusi: 
     - Buat file `VideoAnimasi.java`.
     - Ketik `public class VideoAnimasi extends AsetVisual`.
     - Bikin Constructor bawaan dari super().
     - Bikin method `@Override public String getJenis() { return "Video Animasi"; }` dan `@Override public void tampilkanDetail()`.

2. **Menambah Atribut/Properties Baru di Parent:**
   - Dosen: *"Gimana caranya supaya setiap aset punya ukuran file (size)?"*
   - Solusi: 
     - Buka `AsetVisual.java`.
     - Tambahkan `private double ukuranFile;`.
     - Generate `Getter` dan `Setter` untuk `ukuranFile`.
     - Tambahkan di Constructor, dan jangan lupa di-update juga `super()` yang ada di child class.

3. **Menjelaskan Kenapa Pakai Abstract Class:**
   - Dosen: *"Kenapa AsetVisual dibuat abstract? Kalau saya ganti jadi class biasa error nggak?"*
   - Solusi Jawab: *"Tidak error, Pak/Bu. Tapi secara logika salah. Kita tidak mungkin membuat aset visual mentah-mentahan tanpa tahu jenis aslinya (foto atau vektor). Dengan membuatnya abstract, kita mencegah programmer membuat objek yang tidak jelas bentuknya."*
