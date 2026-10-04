# Deskripsi Singkat Program
Program Sistem Manajemen Produksi Roti dan Kue merupakan aplikasi berbasis Java yang digunakan untuk mengelola data produksi roti dan kue secara terstruktur. Program menyediakan beberapa fitur utama, yaitu menambahkan, menampilkan, memperbarui stok, menghapus, serta mencari data produksi berdasarkan ID atau nama produk. Data produksi mencakup informasi seperti ID, nama produk, stok, harga, jumlah produksi, tanggal produksi, status produksi, serta informasi khusus sesuai jenis produk.

Program ini dikembangkan dengan menerapkan konsep Object-Oriented Programming (OOP) seperti Encapsulation, Inheritance, Polymorphism, Abstraction, dan Interface. Data produk disimpan menggunakan ArrayList<Produk>, sehingga objek Roti dan Kue dapat dikelola dalam satu daftar. Program juga menerapkan pemisahan Model, View, Controller, dan Interface agar struktur kode lebih terorganisir dan mudah dipahami.

# Struktur Package
Struktur package pada program Sistem Manajemen Produksi Roti dan Kue dibuat untuk memisahkan setiap bagian program berdasarkan fungsi dan tanggung jawabnya. Pemisahan ini membuat kode menjadi lebih terstruktur, rapi, dan mudah dikelola, karena bagian untuk mengatur data, proses sistem, tampilan, dan interface ditempatkan pada package yang berbeda.

**1. sistemmanajemenproduksi**
Merupakan package utama yang berisi Main.java sebagai titik awal untuk menjalankan program.

**2. model**
Berisi class Produk, Roti, dan Kue yang berfungsi untuk menyimpan dan merepresentasikan data produk serta menerapkan konsep OOP seperti inheritance, abstraction, dan polymorphism.

**3. controller**
Berisi class ManajemenSistem yang bertanggung jawab terhadap proses pengelolaan data, seperti menambah, menampilkan, memperbarui, menghapus, dan mencari data produksi.

**4. view**
Berisi class View yang menangani tampilan menu dan input dari pengguna, sehingga proses interaksi dengan pengguna terpisah dari proses pengolahan data.

**5. interfaces**
Berisi KelolaProduksi yang merupakan interface untuk mendefinisikan method pengelolaan data yang harus diterapkan oleh ManajemenSistem.

Struktur tersebut menggunakan pemisahan Model, View, Controller, dan Interface sehingga setiap bagian memiliki tanggung jawab masing-masing dan tidak tercampur dalam satu class.

# Penerapan Encapsulation
Encapsulation diterapkan dengan menyembunyikan atribut yang terdapat pada class menggunakan access modifier private. Data tersebut tidak dapat diakses secara langsung dari luar class, tetapi dapat diakses melalui method getter dan diubah melalui setter tertentu.

Contohnya terdapat pada class Produk, seperti atribut idProduk, namaProduk, stok, dan hargaProduk yang menggunakan private.

```java
private final int idProduk;
private final String namaProduk;
private int stok;
private final double hargaProduk;
private final int jumlahProduksi;
private final String tanggalProduksi;
private String statusProduksi;

```
Untuk mengambil nilai atribut digunakan getter, sedangkan perubahan stok dilakukan melalui setter.

```java
public int getStok() {
    return stok;
}

public void setStok(int stok) {
    if (stok >= 0) {
        this.stok = stok;
    }
}
```
Dengan penerapan tersebut, data pada objek dapat dikontrol dan tidak dapat diubah secara sembarangan dari luar class.


# Penerapan Inheritance
Inheritance atau pewarisan diterapkan dengan membuat class Roti dan Kue sebagai turunan dari class Produk.

```java
public class Roti extends Produk

...
public class Kue extends Produk
```
Class Produk berperan sebagai parent class yang memiliki atribut dan method umum seperti ID produk, nama produk, stok, harga, jumlah produksi, tanggal produksi, dan status produksi.
Sementara itu, class Roti memiliki atribut khusus berupa rasa dan ukuranRoti, sedangkan class Kue memiliki atribut jenisKue dan ukuranKue.
Dengan inheritance, class Roti dan Kue dapat menggunakan kembali atribut dan method dari Produk sehingga tidak perlu menuliskan kode yang sama secara berulang.

# Penerapan Polymorpishm 
Polymorphism diterapkan dalam dua bentuk, yaitu Overriding dan Overloading.

**a. Overriding**
Overriding diterapkan ketika class turunan memberikan implementasi sendiri terhadap method yang berasal dari parent class.

Pada class Produk terdapat method:
```java
public abstract void tampilkanJenisProduk();
```
Kemudian method tersebut diimplementasikan oleh class Roti:
```java
@Override
public void tampilkanJenisProduk() {
    System.out.println("Jenis Produk     : Roti");
    System.out.println("Rasa             : " + rasa);
    System.out.println("Ukuran           : " + ukuranRoti);
}
```
Sedangkan class Kue memiliki implementasi sendiri:
```java
@Override
public void tampilkanJenisProduk() {
    System.out.println("Jenis Produk     : Kue");
    System.out.println("Jenis Kue        : " + jenisKue);
    System.out.println("Ukuran           : " + ukuranKue);
}
```
Selain itu, method tampilkanProduk() pada class Produk juga dioverride oleh Roti dan Kue.
Dengan demikian, satu method dapat memiliki perilaku yang berbeda tergantung objek yang menggunakannya.

**b. Overloading**
Overloading diterapkan pada class ManajemenSistem melalui method cariProduk() yang memiliki nama sama tetapi parameter berbeda.

Pencarian berdasarkan ID:
```java
public void cariProduk(int idProduk)
```
Sedangkan pencarian berdasarkan nama:
```java
public void cariProduk(String namaProduk)
```
Kedua method tersebut memiliki nama yang sama, tetapi memiliki parameter yang berbeda. Java akan menentukan method yang digunakan berdasarkan tipe parameter yang diberikan.
Penerapan ini digunakan pada fitur Cari Data Produksi, sehingga pengguna dapat mencari produk berdasarkan ID maupun nama produk.

# Penerapan Abstraction Class dan Method
Abstraction diterapkan dengan menjadikan class Produk sebagai abstract class.

```java
public abstract class Produk
```
Class Produk digunakan sebagai dasar bagi class Roti dan Kue, tetapi tidak dibuat menjadi objek secara langsung.

Selain abstract class, program juga menerapkan abstract method, yaitu:
```java
public abstract void tampilkanJenisProduk();
```
Method tersebut tidak memiliki isi pada class Produk karena setiap jenis produk memiliki informasi khusus yang berbeda.

Class Roti dan Kue wajib memberikan implementasi terhadap method tersebut. Dengan demikian, abstraction digunakan untuk menentukan struktur umum produk sekaligus memberikan kebebasan kepada class turunan untuk menentukan implementasinya masing-masing.

# Penerapan Interface
Program menggunakan interface bernama KelolaProduksi yang berisi method untuk mengelola data produksi.

```java
public interface KelolaProduksi {
    void tambahProduk();
    void tampilkanProduk();
    void updateProduk();
    void hapusProduk();
}
```
Interface tersebut kemudian diimplementasikan oleh class ManajemenSistem.
```java
public class ManajemenSistem implements KelolaProduksi
```
Dengan menerapkan interface, class ManajemenSistem harus menyediakan implementasi dari method yang telah didefinisikan dalam KelolaProduksi.
Interface ini digunakan sebagai kontrak untuk menentukan operasi utama yang harus dimiliki oleh sistem dalam melakukan pengelolaan data produksi.
# Alur Program

**Tampilan Menu Utama**

<img width="296" height="174" alt="image" src="https://github.com/user-attachments/assets/1bfaf710-3d96-458b-94bf-10ffce71f19e" />

Ini adalah tampilan Menu Utama saat program pertama kali di jalankan.

**Tambah Data Produksi**

<img width="347" height="591" alt="image" src="https://github.com/user-attachments/assets/65f3af52-cfde-4fd5-8e1d-421210235fdd" />

Pengguna memilih menu 1 yaitu  Tambah Data Produksi, kemudian memasukkan informasi produk seperti ID Produk 50, nama produk Doraayaki, stok 50, dan harga produk Rp5.000. Sistem juga melakukan validasi input, terlihat ketika pengguna memasukkan harga yang kurang dari Rp1.000 dan format tanggal yang tidak sesuai, kemudian sistem menampilkan pesan kesalahan dan meminta pengguna memasukkan data yang benar.
Setelah data dasar berhasil diinput, pengguna menentukan jumlah produksi sebanyak 100, tanggal produksi 17-05-2025, serta memilih status produksi Selesai melalui pilihan yang telah disediakan. Selanjutnya, pengguna memilih jenis produk Roti, kemudian memasukkan informasi khusus berupa rasa Coklat Keju dan ukuran Medium. Setelah seluruh data berhasil diisi, sistem menampilkan pesan "Data Roti berhasil ditambahkan." dan kembali menampilkan menu utama. Hal ini menunjukkan bahwa data produksi berhasil diproses dan ditambahkan ke dalam sistem.

**Tampilkan Data Produksi**

<img width="267" height="594" alt="image" src="https://github.com/user-attachments/assets/d02d4524-0105-4053-8765-a6a00da427bb" />

Lanjut ke menu Tampilkan Data Produksi, sistem menampilkan seluruh data produksi yang tersimpan di dalam ArrayList<Produk>. Terdapat tiga data produksi yang ditampilkan, yaitu Roti Keju, Brownies Coklat, dan Doraayaki. Setiap data menampilkan informasi seperti ID produk, nama produk, stok, harga, jumlah produksi, tanggal produksi, dan status produksi.
Selain informasi umum, sistem juga menampilkan informasi khusus berdasarkan jenis produknya. Roti Keju dan Doraayaki merupakan produk roti sehingga ditampilkan data rasa dan ukuran, sedangkan Brownies Coklat merupakan produk kue sehingga ditampilkan jenis kue dan ukurannya. Pada bagian akhir setiap data juga terdapat keterangan kategori, yaitu Produk Roti atau Produk Kue. Output ini menunjukkan bahwa data dari berbagai jenis produk dapat disimpan dan ditampilkan melalui satu daftar ArrayList<Produk>, sesuai dengan penerapan Inheritance dan Polymorphism pada program.

**Update Stok Produk Data Produksi**

<img width="340" height="580" alt="image" src="https://github.com/user-attachments/assets/74329cbd-8d0a-4e54-b0cb-09775fd43a3b" />

Pengguna memasukkan ID Produk 90, tetapi sistem tidak menemukan produk dengan ID tersebut sehingga menampilkan pesan “Produk dengan ID tersebut tidak ditemukan.”. Setelah itu, pengguna kembali memilih menu Update Stok Produk dan memasukkan ID Produk 50 yang merupakan produk Doraayaki.
Setelah produk ditemukan, sistem menampilkan informasi produk berupa nama produk dan stok saat ini sebanyak 50. Pengguna kemudian memasukkan stok baru yaitu 30, dan sistem menampilkan pesan “Stok berhasil diperbarui.”. Hal ini menunjukkan bahwa fitur update pada program digunakan secara khusus untuk memperbarui stok produk berdasarkan ID, tanpa mengubah informasi produksi lainnya. Setelah proses selesai, sistem kembali ke menu utama untuk melanjutkan proses berikutnya.

**Hapus Data Produksi**

<img width="419" height="506" alt="image" src="https://github.com/user-attachments/assets/63a6bc76-2b91-4335-b729-2acebcb3ec5d" />

Pengguna memasukkan ID Produk 75, tetapi sistem tidak menemukan data produksi dengan ID tersebut sehingga menampilkan pesan “Produk dengan ID tersebut tidak ditemukan.”. Setelah kembali ke menu utama, pengguna memilih kembali Menu 4 – Hapus Data Produksi dan memasukkan ID Produk 50.
Sistem kemudian menemukan data produksi dengan ID 50 dan menampilkan pesan “Data produksi berhasil dihapus.”. Hal ini menunjukkan bahwa data produksi berhasil dihapus dari daftar penyimpanan berdasarkan ID produk yang dimasukkan. Setelah proses penghapusan selesai, program kembali menampilkan menu utama sehingga pengguna dapat melanjutkan proses lainnya.

**Pencarian ID Berdasarkan ID Produk dan Nama Produk**

**Berdasarkan ID**

<img width="335" height="448" alt="image" src="https://github.com/user-attachments/assets/5590b08d-ad69-48b8-b5d4-bc6de6146eae" />

Menu 5 – Cari Data Produksi, khususnya pencarian berdasarkan ID Produk. Pengguna memilih menu 5. Cari Data Produksi, kemudian sistem menampilkan dua pilihan pencarian, yaitu berdasarkan ID dan berdasarkan Nama. Pengguna memilih pilihan 1, kemudian memasukkan ID Produk 20.
Sistem berhasil menemukan data dengan ID tersebut dan menampilkan seluruh informasi produk Roti Keju, seperti stok 80, harga Rp15.000, jumlah produksi 50, tanggal produksi 20-09-2026, dan status produksi Selesai. Sistem juga menampilkan informasi khusus produk roti berupa rasa Keju, ukuran Medium, serta kategori Produk Roti. Output tersebut menunjukkan bahwa fitur pencarian berdasarkan ID berhasil menemukan dan menampilkan data produksi yang sesuai.

**Berdasarkan Nama Produk**

<img width="307" height="494" alt="image" src="https://github.com/user-attachments/assets/6b5bef20-eb79-461f-ab0e-8ef8c814762b" />

Selanjutnya pencarian berdasarkan Nama Produk. Pengguna memilih menu 5. Cari Data Produksi, kemudian memilih pilihan 2. Cari berdasarkan Nama. Saat pengguna belum memasukkan nama produk, sistem melakukan validasi dan menampilkan pesan “Nama produk tidak boleh kosong.”, sehingga pengguna diminta untuk memasukkan nama produk kembali.
Setelah pengguna memasukkan nama produk Roti Keju, sistem berhasil menemukan data yang sesuai dan menampilkan informasi lengkap produk tersebut, seperti ID 20, stok 80, harga Rp15.000, jumlah produksi 50, tanggal produksi 20-09-2026, dan status produksi Selesai. Sistem juga menampilkan informasi khusus berupa jenis produk Roti, rasa Keju, ukuran Medium, dan kategori Produk Roti. Fitur ini menunjukkan bahwa pencarian berdasarkan nama berhasil dilakukan sekaligus memperlihatkan penerapan polymorphism overloading melalui method cariProduk() yang menerima parameter berupa String untuk pencarian nama produk.

**Keluar Program**

<img width="494" height="286" alt="image" src="https://github.com/user-attachments/assets/2c9c44cf-bb0c-413c-a13f-b4ca19bbb18b" />

Program Manajemen Pengelolaan Produksi Roti dan Kue Selesai
