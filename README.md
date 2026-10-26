# Tema 12 - Pencatatan Keuangan Mahasiswa

Repository ini berisi proyek aplikasi **Pencatatan Keuangan Mahasiswa** yang dikembangkan menggunakan Kotlin Multiplatform (KMP) untuk mata kuliah Pengembangan Aplikasi Mobile. Proyek ini dibangun menggunakan template Compose Multiplatform dengan Kotlin sebagai bahasa pemrograman dan Jetpack Compose untuk membangun antarmuka aplikasi.

## Anggota Kelompok

- **Ketua:** Roberto Charlos Sagala (123140113)
- **Anggota:**
  - Hildyah Maretasya Araffad (123140151)
  - Firman H Gultom (123140171)

## Tangkapan Layar Aplikasi

<img width="193" height="395" alt="Cuplikan layar 2026-10-17 223411" src="https://github.com/user-attachments/assets/19766353-0dd6-40b0-9744-3104bc6c343c" />

<img width="192" height="391" alt="Cuplikan layar 2026-10-17 223328" src="https://github.com/user-attachments/assets/4be4973c-13c0-4f4d-bc65-2213ab1f8374" />


## Struktur Proyek

Proyek ini menggunakan Kotlin Multiplatform dengan target Android, iOS, dan Desktop (JVM).

- **`androidApp`** merupakan modul aplikasi Android.
- **`desktopApp`** merupakan modul aplikasi Desktop berbasis JVM.
- **`iosApp`** berisi proyek aplikasi iOS dan menjadi titik masuk untuk menjalankan aplikasi pada platform Apple.
- **`shared`** berisi kode Kotlin dan antarmuka Compose yang digunakan bersama oleh berbagai platform.

Pada modul `shared`, kode dibagi berdasarkan target platform:

- **`commonMain`** berisi kode umum yang dapat digunakan bersama oleh seluruh target yang didukung.
- **`androidMain`** berisi implementasi khusus Android.
- **`iosMain`** berisi implementasi khusus iOS.
- **`jvmMain`** berisi implementasi khusus Desktop/JVM.

## Menjalankan Aplikasi

Jalankan aplikasi melalui konfigurasi Run yang tersedia di Android Studio atau gunakan perintah Gradle berikut dari direktori utama proyek.

### Android

```bash
./gradlew :androidApp:assembleDebug
```

### Desktop

Menjalankan aplikasi Desktop:

```bash
./gradlew :desktopApp:run
```

Menjalankan Desktop dengan hot reload:

```bash
./gradlew :desktopApp:hotRun --auto
```

### iOS

Buka direktori `iosApp` menggunakan Xcode, lalu pilih simulator atau perangkat iOS untuk menjalankan aplikasi.

## Menjalankan Pengujian

Pengujian dapat dijalankan melalui Android Studio atau menggunakan perintah Gradle berikut.

### Android

```bash
./gradlew :shared:testAndroidHostTest
```

### Desktop

```bash
./gradlew :shared:jvmTest
```

### iOS Simulator

```bash
./gradlew :shared:iosSimulatorArm64Test
```

## Modul 2. Pengujian Simulasi Pencatatan Keuangan Mahasiswa

Program menggunakan `SumberTransaksiPalsu` untuk menghasilkan perubahan status transaksi melalui `Flow`. Setiap status diterima menggunakan `collect`, kemudian ditampilkan di konsol menggunakan fungsi `label()`.

### Cara Menjalankan

Buka PowerShell di folder utama project, lalu jalankan:

```powershell
.\gradlew.bat :desktopApp:runSimulasi --console=plain
```

### Hasil Pengujian

Simulasi berhasil dijalankan dengan urutan output berikut:

```text
Simulasi pencatatan keuangan mahasiswa #1
Transaksi tercatat
Transaksi sedang diproses: Memeriksa transaksi
Transaksi selesai: Pengeluaran berhasil dicatat
Simulasi selesai.
```

Program selesai tanpa error dan Gradle menampilkan `BUILD SUCCESSFUL`.

### Screenshot Hasil Konsol

<img width="304" height="73" alt="image" src="https://github.com/user-attachments/assets/10a3180b-2c18-458c-93b7-996266c80718" />


## Modul 3 - Daftar Transaksi dan Tombol Tambah

Halaman daftar transaksi menampilkan data transaksi dummy menggunakan `LazyColumn` dan komponen `KartuTransaksi`. Daftar transaksi diurutkan berdasarkan ID terbesar menggunakan `sortedByDescending`, sehingga transaksi dengan ID terbesar ditampilkan terlebih dahulu. Setiap kartu menampilkan informasi transaksi, seperti nama transaksi, kategori, dan nominal sesuai data yang digunakan pada aplikasi.

Tombol tambah atau Floating Action Button (FAB) berada di bagian kanan bawah halaman dan tetap tersedia ketika daftar transaksi digulir. Pada implementasi saat ini, tombol tersebut belum digunakan untuk menambahkan transaksi baru atau membuka formulir pencatatan.


## Tampilan Aplikasi Pencatatan Keuangan Mahasiswa

<img width="193" height="395" alt="image" src="https://github.com/user-attachments/assets/f730cdce-a8a6-489f-a92b-047313fed07b" /> 
<img width="193" height="395" alt="image" src="https://github.com/user-attachments/assets/aa227edc-9845-4bed-bfe0-a4765c2581fd" /> 
<img width="193" height="395" alt="image" src="https://github.com/user-attachments/assets/567c0e60-9139-45c0-bb92-ff1495203cde" />


### Panduan Menjalankan Project

#### Menjalankan Aplikasi di Android Studio

1. Buka Android Studio, pilih **Open**, lalu pilih folder utama proyek.
2. Tunggu hingga proses Gradle Sync selesai.
3. Pilih konfigurasi aplikasi yang tersedia.
4. Pilih emulator Android atau perangkat yang terhubung.
5. Klik **Run** untuk menjalankan aplikasi.

#### Menjalankan Simulasi Status Transaksi

Buka tab **Terminal** di Android Studio dengan shell PowerShell. Jalankan perintah berikut dari folder utama proyek:

```powershell
.\gradlew.bat :desktopApp:runSimulasi --console=plain
```

Perintah ini digunakan untuk menjalankan simulasi perubahan status transaksi melalui `SumberTransaksiPalsu` yang menggunakan Kotlin Flow.

### Struktur Project

Proyek ini merupakan Kotlin Multiplatform yang menargetkan Android, iOS, dan Desktop (JVM).

- `androidApp` merupakan modul aplikasi Android.
- `desktopApp` merupakan modul aplikasi Desktop berbasis JVM.
- `iosApp` berisi proyek aplikasi iOS dan menjadi titik masuk untuk menjalankan aplikasi pada platform Apple.
- `shared` berisi kode Kotlin dan antarmuka Compose yang digunakan bersama oleh berbagai platform.

Pada modul `shared`, kode aplikasi ditempatkan pada direktori `commonMain`, sedangkan pengujian JVM ditempatkan pada `jvmTest`.

### Menjalankan Aplikasi

Aplikasi dapat dijalankan melalui konfigurasi Run di Android Studio atau menggunakan perintah Gradle berikut dari direktori utama proyek.

- Android:

  ```bash
  ./gradlew :androidApp:assembleDebug
  ```

- Desktop:

  ```bash
  ./gradlew :desktopApp:run
  ```

- Desktop dengan hot reload:

  ```bash
  ./gradlew :desktopApp:hotRun --auto
  ```

- iOS: buka direktori `iosApp` menggunakan Xcode, kemudian pilih simulator atau perangkat iOS untuk menjalankan aplikasi.

### Menjalankan Pengujian

Pengujian dapat dijalankan melalui Android Studio atau menggunakan perintah Gradle berikut.

- Pengujian Android:

  ```bash
  ./gradlew :shared:testAndroidHostTest
  ```

- Pengujian Desktop:

  ```bash
  ./gradlew :shared:jvmTest
  ```

- Pengujian iOS Simulator:

  ```bash
  ./gradlew :shared:iosSimulatorArm64Test
  ```

## Modul 4. Form Transaksi dan Daftar Reaktif

Pengguna dapat menambahkan transaksi melalui tombol tambah (FAB). Form transaksi menyediakan kolom judul transaksi, nominal, jenis transaksi, kategori, dan catatan opsional. Judul wajib diisi dan nominal harus berupa angka lebih dari Rp0 agar transaksi dapat disimpan.

Setelah transaksi berhasil disimpan, aplikasi kembali ke halaman daftar. Transaksi baru langsung ditampilkan di urutan teratas, sedangkan ringkasan pemasukan, pengeluaran, dan saldo diperbarui secara otomatis melalui `StateFlow`.

Pengelolaan state form dilakukan menggunakan `TransaksiUiState` dan `TransaksiViewModel`. Data transaksi disimpan sementara dalam `PenyimpananTransaksi` menggunakan `MutableStateFlow`, sehingga daftar dapat mengamati perubahan data tanpa perlu dibuka ulang secara manual.

Data masih disimpan di memori, sehingga transaksi yang ditambahkan tidak dijamin bertahan setelah proses aplikasi dihentikan atau aplikasi dijalankan ulang.

### Fitur Aplikasi

- **Pencatatan transaksi:** Menambahkan transaksi pemasukan dan pengeluaran.
- **Validasi form:** Memastikan judul dan nominal memenuhi ketentuan sebelum transaksi disimpan.
- **Kategori transaksi:** Mengelompokkan transaksi berdasarkan kebutuhan kuliah, transportasi, hiburan, dan makanan.
- **Catatan opsional:** Menambahkan keterangan pada transaksi.
- **Ringkasan keuangan:** Menampilkan total pemasukan, total pengeluaran, dan saldo.
- **Daftar reaktif:** Memperbarui daftar transaksi ketika data berubah.
- **Pengelolaan state dengan MVVM:** Memisahkan state dan logika form dari komponen UI.
- **StateFlow:** Mengalirkan perubahan data dari penyimpanan ke tampilan.
- **Pemulihan state saat rotasi:** Mempertahankan halaman dan input form saat konfigurasi layar berubah melalui pengelolaan state yang sesuai.

### Tangkapan Layar Aplikasi

<img width="193" height="395" alt="image" src="https://github.com/user-attachments/assets/2b77a79f-9c0b-4246-a98c-5d0e4afd7a9d" />
<img width="193" height="395" alt="image" src="https://github.com/user-attachments/assets/7f0b4b30-f8aa-410d-8756-6db603af190f" />
<img width="193" height="395" alt="image" src="https://github.com/user-attachments/assets/248cea4c-b7ab-4456-9233-7d2d57437881" />


## Teknologi yang Digunakan

- Kotlin
- Kotlin Multiplatform
- Compose Multiplatform
- Material 3
- Kotlin Coroutines
- Kotlin Flow dan StateFlow
- ViewModel
- Gradle

## Struktur Project

Kode bersama aplikasi berada pada modul `shared`, khususnya source set `commonMain`. Struktur direktori utama yang berkaitan dengan fitur pencatatan keuangan adalah sebagai berikut.

```text
shared/
└── src/
    └── commonMain/
        └── kotlin/
            └── org/example/project/
                ├── App.kt
                ├── data/
                │   └── PenyimpananTransaksi.kt
                ├── model/
                │   ├── TransaksiKeuangan.kt
                │   ├── KategoriKeuangan.kt
                │   ├── StatusTransaksi.kt
                │   └── TransaksiUiState.kt
                └── ui/
                    ├── LayarUtama.kt
                    ├── LayarDaftarTransaksi.kt
                    ├── FormTransaksiScreen.kt
                    ├── KolomTeks.kt
                    └── TransaksiViewModel.kt
```

Struktur di atas menggambarkan file fitur yang telah dibuat. Sesuaikan lokasi direktori dengan struktur aktual repository jika berbeda.

## Arsitektur MVVM

Aplikasi menerapkan pola MVVM untuk memisahkan tanggung jawab setiap bagian.

| Komponen | Tanggung jawab |
|---|---|
| Model | Merepresentasikan data transaksi, kategori, dan state UI. |
| View | Menampilkan form, daftar transaksi, serta ringkasan keuangan menggunakan Compose. |
| ViewModel | Mengelola state form, validasi, dan proses penyimpanan transaksi. |
| Penyimpanan | Menyimpan daftar transaksi sementara menggunakan `MutableStateFlow`. |

Alur data transaksi:

```text
Pengguna
   ↓
FormTransaksiScreen
   ↓
TransaksiViewModel
   ↓
PenyimpananTransaksi
   ↓
StateFlow daftar transaksi
   ↓
LayarDaftarTransaksi
```

## Panduan Menjalankan Project

### Menjalankan aplikasi di Android Studio

1. Buka Android Studio.
2. Pilih **Open**, kemudian pilih folder utama repository.
3. Tunggu hingga proses Gradle Sync selesai.
4. Pilih konfigurasi `androidApp`.
5. Pilih emulator Android atau perangkat fisik yang sudah terhubung.
6. Klik **Run** untuk menjalankan aplikasi.

Nama konfigurasi dapat berbeda sesuai pengaturan project.

### Menjalankan aplikasi Android melalui Terminal

Dari folder utama project, jalankan perintah berikut pada PowerShell:

```powershell
.\gradlew.bat :androidApp:assembleDebug
```

Untuk menjalankan aplikasi secara langsung, gunakan konfigurasi Run yang tersedia di Android Studio.

### Menjalankan aplikasi Desktop

Jika target Desktop tersedia pada konfigurasi Gradle project, jalankan:

```powershell
.\gradlew.bat :desktopApp:run
```

Perintah tersebut perlu disesuaikan apabila nama modul Desktop di repository berbeda.

## Pengujian Fitur

Pengujian manual dilakukan untuk memastikan fitur utama berjalan dengan baik.

- Membuka halaman daftar transaksi.
- Membuka form melalui tombol tambah.
- Memastikan tombol simpan tidak aktif ketika input wajib belum valid.
- Menambahkan transaksi pemasukan dan pengeluaran.
- Memastikan transaksi baru muncul di urutan teratas.
- Memastikan total pemasukan, total pengeluaran, dan saldo diperbarui.
- Memutar layar dan memeriksa apakah halaman serta input form tetap terjaga.


## Tujuan Proyek

Aplikasi ini dirancang sebagai proyek pembelajaran pengembangan aplikasi mobile menggunakan Kotlin Multiplatform. Tema yang diangkat adalah pencatatan keuangan mahasiswa, dengan tujuan menjadi dasar pengembangan aplikasi untuk membantu mahasiswa mencatat dan mengelola pengeluaran keuangan mereka.
