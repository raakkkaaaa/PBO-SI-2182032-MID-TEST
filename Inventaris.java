import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Inventaris {
    private List<Barang> daftarBarang;
    private final String fileName = "data_barang.dat";

    public Inventaris() {
        daftarBarang = new ArrayList<>();
        loadFromFile();
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
        saveToFile();
    }

    public void editBarang(String namaBarang, int stokBaru, double hargaBaru) {
        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                barang.setStok(stokBaru);
                saveToFile();
                break;
            }
        }
    }

    public void hapusBarang(String namaBarang) {
        daftarBarang.removeIf(barang -> barang.getNama().equalsIgnoreCase(namaBarang));
        saveToFile();
    }

    public void tampilkanDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang dalam inventaris.");
        } else {
            for (Barang barang : daftarBarang) {
                System.out.println(barang);
            }
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(daftarBarang);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(fileName);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                daftarBarang = (List<Barang>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Gagal memuat data: " + e.getMessage());
            }
        }
    }
}
