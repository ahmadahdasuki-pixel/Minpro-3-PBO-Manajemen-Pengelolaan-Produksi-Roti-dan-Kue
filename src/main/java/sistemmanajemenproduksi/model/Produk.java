package sistemmanajemenproduksi.model;

public abstract class Produk {
private final int idProduk;
private final String namaProduk;
private int stok;
private final double hargaProduk;
private final int jumlahProduksi;
private final String tanggalProduksi;
private String statusProduksi;

    public Produk(int idProduk, String namaProduk, int stok,
                  double hargaProduk, int jumlahProduksi,
                  String tanggalProduksi, String statusProduksi) {

        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.stok = stok;
        this.hargaProduk = hargaProduk;
        this.jumlahProduksi = jumlahProduksi;
        this.tanggalProduksi = tanggalProduksi;
        this.statusProduksi = statusProduksi;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public int getStok() {
        return stok;
    }

    public double getHargaProduk() {
        return hargaProduk;
    }

    public int getJumlahProduksi() {
        return jumlahProduksi;
    }

    public String getTanggalProduksi() {
        return tanggalProduksi;
    }

    public String getStatusProduksi() {
        return statusProduksi;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        }
    }

    public void setStatusProduksi(String statusProduksi) {
        if (statusProduksi != null && !statusProduksi.trim().isEmpty()) {
            this.statusProduksi = statusProduksi;
        }
    }

    public abstract void tampilkanJenisProduk();

    public void tampilkanProduk() {
    System.out.println("ID Produk        : " + idProduk);
    System.out.println("Nama Produk      : " + namaProduk);
    System.out.println("Stok             : " + stok);
    System.out.println("Harga            : Rp" + hargaProduk);
    System.out.println("Jumlah Produksi  : " + jumlahProduksi);
    System.out.println("Tanggal Produksi : " + tanggalProduksi);
    System.out.println("Status Produksi  : " + statusProduksi);

        tampilkanJenisProduk();
    }
}