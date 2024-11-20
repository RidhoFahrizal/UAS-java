package src;

import java.util.LinkedList;

public class HistoryTransaction {
    private LinkedList<Transaction> transactions = new LinkedList<>();

    // Menambahkan transaksi baru
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Menampilkan semua transaksi
    public void displayAllTransaction() {
        System.out.println("List of All Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // Menampilkan transaksi berdasarkan ID
    public void displayTransactionById(int id) {
        System.out.println("Transaction Details for ID: " + id);
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                System.out.println(transaction);
                return;
            }
        }
        System.out.println("Transaction not found.");
    }

    // Getter untuk transaksi (untuk GUI)
    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }
}
