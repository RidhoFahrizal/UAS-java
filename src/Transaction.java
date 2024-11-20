package src;

public class Transaction {
    private int id;
    private int nominal;
    private String description;

    // Constructor dengan parameter
    public Transaction(int id, int nominal, String description) {
        this.id = id;
        this.nominal = nominal;
        this.description = description;
    }

    // Constructor default (jika diperlukan)
    public Transaction() {
        this.id = 0;
        this.nominal = 0;
        this.description = "";
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Overriding toString untuk representasi data transaksi
    @Override
    public String toString() {
        return "Transaction{" +
               "ID=" + id +
               ", Nominal=" + nominal +
               ", Description='" + description + '\'' +
               '}';
    }
}
