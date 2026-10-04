# Deskripsi Singkat Program
Program Sistem Manajemen Produksi Roti dan Kue merupakan aplikasi berbasis Java yang digunakan untuk mengelola data produksi roti dan kue secara terstruktur. Program menyediakan beberapa fitur utama, yaitu menambahkan, menampilkan, memperbarui stok, menghapus, serta mencari data produksi berdasarkan ID atau nama produk. Data produksi mencakup informasi seperti ID, nama produk, stok, harga, jumlah produksi, tanggal produksi, status produksi, serta informasi khusus sesuai jenis produk.

Program ini dikembangkan dengan menerapkan konsep Object-Oriented Programming (OOP) seperti Encapsulation, Inheritance, Polymorphism, Abstraction, dan Interface. Data produk disimpan menggunakan ArrayList<Produk>, sehingga objek Roti dan Kue dapat dikelola dalam satu daftar. Program juga menerapkan pemisahan Model, View, Controller, dan Interface agar struktur kode lebih terorganisir dan mudah dipahami.

# Struktur Package
Struktur package pada program Sistem Manajemen Produksi Roti dan Kue dibuat untuk memisahkan setiap bagian program berdasarkan fungsi dan tanggung jawabnya. Pemisahan ini membuat kode menjadi lebih terstruktur, rapi, dan mudah dikelola, karena bagian untuk mengatur data, proses sistem, tampilan, dan interface ditempatkan pada package yang berbeda.

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
# Penerapan Polymorpishm 
# Penerapan Abstraction
# Penerapan Interface
# Alur Program
