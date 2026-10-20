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

## Pengujian Simulasi Pencatatan Keuangan Mahasiswa

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

Simpan screenshot hasil pengujian di folder utama repository dengan nama `hasil-pengujian.png`.

<img width="304" height="73" alt="image" src="https://github.com/user-attachments/assets/10a3180b-2c18-458c-93b7-996266c80718" />


## Tujuan Proyek

Aplikasi ini dirancang sebagai proyek pembelajaran pengembangan aplikasi mobile menggunakan Kotlin Multiplatform. Tema yang diangkat adalah pencatatan keuangan mahasiswa, dengan tujuan menjadi dasar pengembangan aplikasi untuk membantu mahasiswa mencatat dan mengelola pengeluaran keuangan mereka.
