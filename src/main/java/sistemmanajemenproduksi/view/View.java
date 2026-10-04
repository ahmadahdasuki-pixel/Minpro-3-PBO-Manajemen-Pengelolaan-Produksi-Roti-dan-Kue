package sistemmanajemenproduksi.view;

import java.util.Scanner;
import sistemmanajemenproduksi.controller.ManajemenSistem;

public class View {
    private final Scanner scanner;
    public View() {
        scanner = new Scanner(System.in);
    }
    
    public void tampilkanMenu() {

    System.out.println();
    System.out.println("======================================");
    System.out.println(" SISTEM MANAJEMEN PRODUKSI ROTI & KUE");
    System.out.println("======================================");
    System.out.println("1. Tambah Data Produksi");
    System.out.println("2. Tampilkan Data Produksi");
    System.out.println("3. Update Stok Produk");
    System.out.println("4. Hapus Data Produksi");
    System.out.println("5. Cari Data Produksi");
    System.out.println("6. Keluar");
    System.out.println("======================================");
}
    
    public void jalankanMenu(ManajemenSistem controller) {

    int pilihan;
    do {
        tampilkanMenu();
        pilihan = inputMenu();

        switch (pilihan) {
            case 1:
                controller.tambahProduk();
                break;
            case 2:
                controller.tampilkanProduk();
                break;
            case 3:
                controller.updateProduk();
                break;
            case 4:
                controller.hapusProduk();
                break;
            case 5:
                menuPencarian(controller);
                break;
            case 6:
                System.out.println("Program selesai. Terima kasih!");
                break;
        }

    } while (pilihan != 6);
}

    public int inputMenu() {

        while (true) {
            System.out.print("Pilih menu : ");
            if (scanner.hasNextInt()) {
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                if (pilihan >= 1 && pilihan <= 6) {
                    return pilihan;
                }
                System.out.println("Pilihan menu hanya 1 sampai 6.");
            } else {
                System.out.println("Input harus berupa angka.");
                scanner.nextLine();
            }
        }
    }

    public void menuPencarian(ManajemenSistem controller) {
    System.out.println();
    System.out.println("===== CARI DATA PRODUKSI =====");
    System.out.println("1. Cari berdasarkan ID");
    System.out.println("2. Cari berdasarkan Nama");
    System.out.println("==============================");

    while (true) {
        System.out.print("Pilih pencarian : ");
        if (scanner.hasNextInt()) {
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            if (pilihan == 1) {
                int idProduk = inputId();
                controller.cariProduk(idProduk);
                break;

            } else if (pilihan == 2) {
                String namaProduk = inputNamaProduk();
                controller.cariProduk(namaProduk);
                break;

            } else {
                System.out.println("Pilihan hanya 1 atau 2.");
            }
        } else {
            System.out.println("Input harus berupa angka.");
            scanner.nextLine();
        }
    }
}
    
    public int inputId() {

        while (true) {
            System.out.print("ID Produk : ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine();
                if (id > 0) {
                    return id;
                }
                System.out.println("ID produk harus lebih dari 0.");
            } else {
                System.out.println("ID produk harus berupa angka.");
                scanner.nextLine();
            }
        }
    }

    public String inputNamaProduk() {

        while (true) {
            System.out.print("Nama Produk : ");
            String nama = scanner.nextLine();
            if (!nama.trim().isEmpty()) {
                return nama;
            }
            System.out.println("Nama produk tidak boleh kosong.");
        }
    }

    public int inputStok() {

        while (true) {
            System.out.print("Stok : ");
            if (scanner.hasNextInt()) {
                int stok = scanner.nextInt();
                scanner.nextLine();
                if (stok >= 0) {
                    return stok;
                }
                System.out.println("Stok tidak boleh kurang dari 0.");
            } else {
                System.out.println("Stok harus berupa angka.");
                scanner.nextLine();
            }
        }
    }

    public double inputHarga() {

        while (true) {
            System.out.print("Harga Produk : ");
            if (scanner.hasNextDouble()) {
                double harga = scanner.nextDouble();
                scanner.nextLine();
                if (harga >= 1000) {
                    return harga;
                }
                System.out.println("Harga produk minimal Rp1.000.");
            } else {
                System.out.println("Harga produk harus berupa angka.");
                scanner.nextLine();
            }
        }
    }

    public int inputJumlahProduksi() {

        while (true) {
            System.out.print("Jumlah Produksi : ");
            if (scanner.hasNextInt()) {
                int jumlah = scanner.nextInt();
                scanner.nextLine();
                if (jumlah > 0) {
                    return jumlah;
                }
                System.out.println("Jumlah produksi harus lebih dari 0.");
            } else {
                System.out.println("Jumlah produksi harus berupa angka.");
                scanner.nextLine();
            }
        }
    }

    public String inputTanggalProduksi() {

        while (true) {
            System.out.print("Tanggal Produksi (dd-MM-yyyy) : ");
            String tanggal = scanner.nextLine();
            if (tanggal.matches("\\d{2}-\\d{2}-\\d{4}")) {
                return tanggal;
            }
            System.out.println("Format tanggal harus dd-MM-yyyy.");
        }
    }

    public String inputStatusProduksi() {

        while (true) {
            System.out.println();
            System.out.println("===== STATUS PRODUKSI =====");
            System.out.println("1. Diproses");
            System.out.println("2. Selesai");
            System.out.println("3. Dibatalkan");
            System.out.print("Pilih status : ");

            if (scanner.hasNextInt()) {
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 1:
                        return "Diproses";
                    case 2:
                        return "Selesai";
                    case 3:
                        return "Dibatalkan";
                    default:
                        System.out.println(
                                "Pilihan status hanya 1 sampai 3."
                        );
                }

            } else {
                System.out.println("Input harus berupa angka.");
                scanner.nextLine();
            }
        }
    }

    public int inputJenisProduk() {

        while (true) {
            System.out.println();
            System.out.println("===== JENIS PRODUK =====");
            System.out.println("1. Roti");
            System.out.println("2. Kue");
            System.out.print("Pilih jenis produk : ");

            if (scanner.hasNextInt()) {
                int jenis = scanner.nextInt();
                scanner.nextLine();
                if (jenis == 1 || jenis == 2) {
                    return jenis;
                }
                System.out.println(
                        "Pilihan jenis produk hanya 1 atau 2."
                );
            } else {
                System.out.println("Input harus berupa angka.");
                scanner.nextLine();
            }
        }
    }

    public String inputRasa() {

        while (true) {
            System.out.print("Rasa : ");
            String rasa = scanner.nextLine();
            if (!rasa.trim().isEmpty()) {
                return rasa;
            }
            System.out.println("Rasa roti tidak boleh kosong.");
        }
    }

    public String inputUkuranRoti() {

        while (true) {
            System.out.print("Ukuran Roti : ");
            String ukuran = scanner.nextLine();
            if (!ukuran.trim().isEmpty()) {
                return ukuran;
            }
            System.out.println("Ukuran roti tidak boleh kosong.");
        }
    }

    public String inputJenisKue() {

        while (true) {
            System.out.print("Jenis Kue : ");
            String jenisKue = scanner.nextLine();
            if (!jenisKue.trim().isEmpty()) {
                return jenisKue;
            }
            System.out.println("Jenis kue tidak boleh kosong.");
        }
    }

    public String inputUkuranKue() {

        while (true) {
            System.out.print("Ukuran Kue : ");
            String ukuran = scanner.nextLine();
            if (!ukuran.trim().isEmpty()) {
                return ukuran;
            }
            System.out.println("Ukuran kue tidak boleh kosong.");
        }
    }
    
    public void tutupScanner() {
        scanner.close();
    }
}