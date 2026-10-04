package sistemmanajemenproduksi.controller;

import java.util.ArrayList;
import sistemmanajemenproduksi.model.Kue;
import sistemmanajemenproduksi.model.Produk;
import sistemmanajemenproduksi.model.Roti;
import sistemmanajemenproduksi.view.View;
import sistemmanajemenproduksi.controller.KelolaProduksi;

public class ManajemenSistem implements KelolaProduksi{

    private final ArrayList<Produk> daftarProduk;
    private final View view;

    public ManajemenSistem(View view) {
        this.view = view;
        daftarProduk = new ArrayList<>();

        tambahDataAwal();
    }

    private void tambahDataAwal() {

        Roti roti = new Roti(20, "Roti Keju", 80, 15000, 50, "20-09-2026", "Selesai", "Keju", "Medium" );

        Kue kue = new Kue(17, "Brownies Coklat", 50, 25000, 75, "19-09-2026", "Diproses", "Brownies","Sedang");

        daftarProduk.add(roti);
        daftarProduk.add(kue);
    }
    @Override
    public void tambahProduk() {
        System.out.println();
        System.out.println("================================");
        System.out.println("===== TAMBAH DATA PRODUKSI =====");
        System.out.println("================================");

        int idProduk;
        while (true) {
            idProduk = view.inputId();
            if (!idSudahAda(idProduk)) {
                break;
            }

            System.out.println("ID Produk sudah digunakan!");
        }

        String namaProduk = view.inputNamaProduk();
        int stok = view.inputStok();
        double hargaProduk = view.inputHarga();
        int jumlahProduksi = view.inputJumlahProduksi();
        String tanggalProduksi = view.inputTanggalProduksi();
        String statusProduksi = view.inputStatusProduksi();
        int jenisProduk = view.inputJenisProduk();

        if (jenisProduk == 1) {
            System.out.println();
            System.out.println("=====================");
            System.out.println("===== DATA ROTI =====");
            System.out.println("=====================");

            String rasa = view.inputRasa();
            String ukuranRoti = view.inputUkuranRoti();

            Roti rotiBaru = new Roti(
                    idProduk,
                    namaProduk,
                    stok,
                    hargaProduk,
                    jumlahProduksi,
                    tanggalProduksi,
                    statusProduksi,
                    rasa,
                    ukuranRoti
            );

            daftarProduk.add(rotiBaru);
            System.out.println("Data Roti berhasil ditambahkan.");

        } else {

            System.out.println();
            System.out.println("====================");
            System.out.println("===== DATA KUE =====");
            System.out.println("====================");

            String jenisKue = view.inputJenisKue();
            String ukuranKue = view.inputUkuranKue();

            Kue kueBaru = new Kue(
                    idProduk,
                    namaProduk,
                    stok,
                    hargaProduk,
                    jumlahProduksi,
                    tanggalProduksi,
                    statusProduksi,
                    jenisKue,
                    ukuranKue
            );

            daftarProduk.add(kueBaru);
            System.out.println("Data Kue berhasil ditambahkan.");
        }
    }

    private boolean idSudahAda(int idProduk) {
        for (Produk produk : daftarProduk) {
            if (produk.getIdProduk() == idProduk) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void tampilkanProduk() {

        System.out.println();
        System.out.println("=========================");
        System.out.println("===== DATA PRODUKSI =====");
        System.out.println("=========================");

        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada data produksi.");
            return;
        }
        for (Produk produk : daftarProduk) {

            System.out.println();
            produk.tampilkanProduk();
        }
    }

    @Override
    public void updateProduk() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("===== UPDATE STOK PRODUK =====");
        System.out.println("==============================");

        int idProduk = view.inputId();
        for (Produk produk : daftarProduk) {
            if (produk.getIdProduk() == idProduk) {
                System.out.println();
                System.out.println("Produk ditemukan.");
                System.out.println("Nama Produk : " + produk.getNamaProduk());
                System.out.println("Stok Saat Ini : " + produk.getStok());

                int stokBaru = view.inputStok();

                produk.setStok(stokBaru);
                System.out.println("Stok berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Produk dengan ID tersebut tidak ditemukan.");
    }

    @Override
    public void hapusProduk() {

        System.out.println();
        System.out.println("===============================");
        System.out.println("===== HAPUS DATA PRODUKSI =====");
        System.out.println("===============================");
        int idProduk = view.inputId();
        for (int i = 0; i < daftarProduk.size(); i++) {
            if (daftarProduk.get(i).getIdProduk() == idProduk) {
                daftarProduk.remove(i);
                System.out.println("Data produksi berhasil dihapus.");
                return;
            }
        }
        System.out.println("Produk dengan ID tersebut tidak ditemukan.");
    }
    
// Overloading 1: mencari berdasarkan ID
    public void cariProduk(int idProduk) {

    System.out.println();
    System.out.println("===== HASIL PENCARIAN =====");

    for (Produk produk : daftarProduk) {

        if (produk.getIdProduk() == idProduk) {

            produk.tampilkanProduk();
            return;
        }
    }

    System.out.println("Produk dengan ID tersebut tidak ditemukan.");
}


// Overloading 2: mencari berdasarkan nama
    public void cariProduk(String namaProduk) {

    System.out.println();
    System.out.println("===== HASIL PENCARIAN =====");

    boolean ditemukan = false;

    for (Produk produk : daftarProduk) {

        if (produk.getNamaProduk().equalsIgnoreCase(namaProduk)) {

            produk.tampilkanProduk();
            ditemukan = true;
        }
    }

    if (!ditemukan) {

        System.out.println(
                "Produk dengan nama tersebut tidak ditemukan."
        );
    }
}


}

