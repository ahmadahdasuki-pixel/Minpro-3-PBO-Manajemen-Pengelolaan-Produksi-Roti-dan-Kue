# Deskripsi Singkat Program
Program Sistem Manajemen Produksi Roti dan Kue merupakan aplikasi berbasis Java yang digunakan untuk mengelola data produksi roti dan kue secara terstruktur. Program menyediakan beberapa fitur utama, yaitu menambahkan, menampilkan, memperbarui stok, menghapus, serta mencari data produksi berdasarkan ID atau nama produk. Data produksi mencakup informasi seperti ID, nama produk, stok, harga, jumlah produksi, tanggal produksi, status produksi, serta informasi khusus sesuai jenis produk.

Program ini dikembangkan dengan menerapkan konsep Object-Oriented Programming (OOP) seperti Encapsulation, Inheritance, Polymorphism, Abstraction, dan Interface. Data produk disimpan menggunakan ArrayList<Produk>, sehingga objek Roti dan Kue dapat dikelola dalam satu daftar. Program juga menerapkan pemisahan Model, View, Controller, dan Interface agar struktur kode lebih terorganisir dan mudah dipahami.

# Struktur Package
Struktur package pada program Sistem Manajemen Produksi Roti dan Kue dibuat untuk memisahkan setiap bagian program berdasarkan fungsi dan tanggung jawabnya. Pemisahan ini membuat kode menjadi lebih terstruktur, rapi, dan mudah dikelola, karena bagian untuk mengatur data, proses sistem, tampilan, dan interface ditempatkan pada package yang berbeda.

sistemmanajemenproduksi
│
├── Main.java
│
├── controller
│   └── ManajemenSistem.java
│
├── model
│   ├── Produk.java
│   ├── Roti.java
│   └── Kue.java
│
├── interfaces
│   └── KelolaProduksi.java
│
└── view
    └── View.java

sistemmanajemenproduksi
Merupakan package utama yang berisi Main.java sebagai titik awal untuk menjalankan program.

**1. model**
Berisi class Produk, Roti, dan Kue yang berfungsi untuk menyimpan dan merepresentasikan data produk serta menerapkan konsep OOP seperti inheritance, abstraction, dan polymorphism.

**2. controller**
Berisi class ManajemenSistem yang bertanggung jawab terhadap proses pengelolaan data, seperti menambah, menampilkan, memperbarui, menghapus, dan mencari data produksi.

**3. view**
Berisi class View yang menangani tampilan menu dan input dari pengguna, sehingga proses interaksi dengan pengguna terpisah dari proses pengolahan data.

**4. interfaces**
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
