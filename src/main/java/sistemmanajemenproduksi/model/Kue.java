package sistemmanajemenproduksi.model;

public class Kue extends Produk {

    private final String jenisKue;
    private final String ukuranKue;

    public Kue(int idProduk, String namaProduk, int stok,
               double hargaProduk, int jumlahProduksi,
               String tanggalProduksi, String statusProduksi,
               String jenisKue, String ukuranKue) {

        super(idProduk, namaProduk, stok, hargaProduk,
              jumlahProduksi, tanggalProduksi, statusProduksi);

        this.jenisKue = jenisKue;
        this.ukuranKue = ukuranKue;
    }

    public String getJenisKue() {
        return jenisKue;
    }

    public String getUkuranKue() {
        return ukuranKue;
    }

    @Override
    public void tampilkanJenisProduk() {

        System.out.println("Jenis Produk     : Kue");
        System.out.println("Jenis Kue        : " + jenisKue);
        System.out.println("Ukuran           : " + ukuranKue);
    }

    @Override
    public void tampilkanProduk() {

        super.tampilkanProduk();

        System.out.println("Kategori         : Produk Kue");
    }
}