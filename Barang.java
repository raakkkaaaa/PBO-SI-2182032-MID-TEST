import java.io.Serializable;

public class Barang implements Serializable {
    private String nama;
    private int stok;
    private double harga;
    private String deskripsi;

    public Barang(String nama, int stok, double harga, String deskripsi) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Stok: " + stok + ", Harga: " + harga + ", Deskripsi: " + deskripsi;
    }
}
