import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventaris inventaris = new Inventaris();

        while (true) {
            System.out.println("\nAplikasi Manajemen Inventaris Barang");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Edit Barang");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Tampilkan Daftar Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Jumlah Stok: ");
                    int stok = scanner.nextInt();
                    System.out.print("Harga: ");
                    double harga = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.print("Deskripsi: ");
                    String deskripsi = scanner.nextLine();

                    Barang barang = new Barang(nama, stok, harga, deskripsi);
                    inventaris.tambahBarang(barang);
                    System.out.println("Barang berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.print("Nama Barang yang ingin diedit: ");
                    String namaEdit = scanner.nextLine();
                    System.out.print("Stok baru: ");
                    int stokBaru = scanner.nextInt();
                    System.out.print("Harga baru: ");
                    double hargaBaru = scanner.nextDouble();
                    inventaris.editBarang(namaEdit, stokBaru, hargaBaru);
                    System.out.println("Barang berhasil diedit.");
                    break;

                case 3:
                    System.out.print("Nama Barang yang ingin dihapus: ");
                    String namaHapus = scanner.nextLine();
                    inventaris.hapusBarang(namaHapus);
                    System.out.println("Barang berhasil dihapus.");
                    break;

                case 4:
                    inventaris.tampilkanDaftarBarang();
                    break;

                case 5:
                    System.out.println("Keluar dari aplikasi...");
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
