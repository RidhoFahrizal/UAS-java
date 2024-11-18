package src;

public class User {
    private String name;
    private String studentID;
    private int TotalCash;
    private Account account;

    public User(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public int checkClassChash() {
        return this.TotalCash;
    }

    // Method untuk mengakses CashBook
    public void testSeekCashBook(CashBook cashBook) {
        System.out.println(cashBook.list); // Mengakses atribut list dari objek CashBook
    }
}
