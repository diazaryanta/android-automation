# Sauce Labs Mobile Automation Project 📱

Proyek ini adalah framework *automation* pengujian _mobile_ untuk aplikasi **Sauce Labs My Demo App** (Android). Framework ini dibangun menggunakan **Java 21**, **Appium 2.x**, dan **TestNG** dengan menerapkan design pattern **Page Object Model (POM)** untuk memastikan kode yang dihasilkan rapi, mudah dirawat (*maintainable*), dan dapat digunakan kembali (*reusable*).

---

## 🛠️ Tech Stack
* **Language:** Java 21
* **Automation Tool:** Appium 2.x (UIAutomator2 Driver)
* **Testing Framework:** TestNG
* **Build Tool:** Gradle
* **IDE:** IntelliJ IDEA
* **Platform:** Android 14 (API 34)
---

## 📂 Project Structure
Struktur folder diatur sedemikian rupa untuk memisahkan antara konfigurasi driver, identifikasi elemen halaman, dan skenario pengujian utama:

```text
saucelabs-mobile-automation/
├── apk/                         # File aplikasi .apk (saucedemo.apk)
├── src/test/java/
│   ├── base/                    # Setup & Teardown Driver (BaseTest.java)
│   ├── pages/                   # Page Objects (Locator & Action)
│   │   ├── LoginPage.java
│   │   └── AddToCartPage.java
│   ├── tests/                   # Skenario Pengujian (Test Cases)
│   │   ├── LoginTest.java
│   │   └── AddToCartTest.java
│   └── utils/                   # Konfigurasi Tambahan (AppConfig.java)
├── build.gradle                 # Manajemen Dependensi Project
├── README.md                    # Dokumentasi panduan penggunaan proyek saucelabs
└── settings.gradle              # Nama dari proyek yang dibuat
```
---

## ⚙️ Configuration & Desire Capabilities
Skrip ini terhubung ke Appium Server melalui konfigurasi berikut (seperti yang terlihat pada Appium Inspector):

| Capability      | Type |      Value       |
|:----------------|:----:|:----------------:|
| platformName    | Text |     Android      |
| platformVersion | Text |        14        |
| deviceName      | Text |  emulator-5554   |
| appWaitActivity | Text |        *         |
| automationName  | Text |  UIAutomation2   |
| app             | Text | mda-2.2.0-25.apk |
---

## 🧪 Scenario Test

| Fitur       | Status |               Catatan                |
|:------------|:------:|:------------------------------------:|
| Login       |   ✅    | Berhasil dengan akun bod@example.com |
| Add to Cart |   ✅    |      Badge bertambah menjadi 1       |
---

## 🚀 How to Run

1. Persiapan: Pastikan Android Emulator (Android 14) sudah aktif dan berada di Home Screen.
2. Appium Server: Jalankan Appium Server melalui terminal Mac dengan perintah:`Appium`
3. Terminal : Ketikkan perintah diterminal Mac `./gradlew clean test`
---

# 📝 Reflection Questions
1. **Analisis Critical Path Automation**  

   Dari seluruh rangkaian test automation yang telah dibuat, skenario yang paling kritikal adalah **Login Automation** dan **Add-to-Cart Automation**.
    * **Mengapa Sangat Penting?**  
      Login merupakan "pintu masuk" utama. Hampir seluruh fitur fungsional lainnya bergantung pada keberhasilan proses autentikasi. Sementara itu, Add-to-Cart adalah alur bisnis inti.

    * **Risiko jika gagal**  
      Jika skenario Login gagal maka kedepannya akan menjadi *blocker* total bagi pengujian fitur lainnya. Jika skenario Add-to-Cart gagal namun aplikasi tetap dirilis, risikonya adalah kerugian finansial langsung bagi perusahaan karena pengguna tidak dapat melakukan pembelian.
   

2. **Analisis Locator & Stabilitas Testing**  
Tantangan terbesar saat mengidentifikasi elemen menggunakan Appium Inspector adalah menghadapi elemen yang bersifat dinamis atau tidak konsisten kemunculannya, terutama pada **Badge Angka Keranjang _(Cart Badge)_**.

    * **Kendala yang ditemui:**  
   Elemen badge keranjang tidak muncul dalam *App Source* jika keranjang kosong.
    * **Pertimbangan menentukan locator:**  
   Saya memprioritaskan penggunaan **Accessibility ID (content-desc)** karena paling stabil dan memang dirancang khusus untuk keperluan pengujian. Saya menghindari penggunaan **XPath** yang terlalu panjang karena sangat rentan terhadap perubahan struktur UI aplikasi.
    * **Pengaruh terhadap Reliability:**  
      Pemilihan locator yang stabil meningkatkan **Reliability** skrip agar tidak mudah "patah" saat ada update minor pada desain aplikasi. Penanganan elemen dinamis dengan Exception Handling juga berhasil mengurangi tingkat **Flakiness**

# 📹 Video
![HasilPengujianMobileAutomation](https://github.com/user-attachments/assets/498e6df4-f1a1-4a22-a02d-e85f07da83d5)
