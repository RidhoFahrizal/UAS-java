
import java.util.ArrayList;
import java.util.List;

public class CatatanTransaksi {
    List<Transaksi> transaksi  = new ArrayList<>();

    public void tambahTransaksi(int id, int nominal, String keterangan){
        Transaksi transaksiBaru = new Transaksi(id, nominal, keterangan);
        transaksi.add(transaksiBaru);
    }

    public void displayAllTransaction() {
        if (transaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi yang tercatat.");
        } else {
            System.out.println("Daftar Semua Transaksi:");
            for (Transaksi t : transaksi) {
                System.out.println("ID: " + t.id + ", Nominal: " + t.nominal + ", Keterangan: " + t.keterangan);
            }
        }
    }

    // Menampilkan transaksi berdasarkan ID
    public void displayTransactionById(int id) {
        boolean found = false;
        for (Transaksi t : transaksi) {
            if (t.id == id) {
                System.out.println("Detail Transaksi:");
                System.out.println("ID: " + t.id + ", Nominal: " + t.nominal + ", Keterangan: " + t.keterangan);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Transaksi dengan ID " + id + " tidak ditemukan.");
        }
    }
}