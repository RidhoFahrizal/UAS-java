package src;

public class Treasurer extends User {

    private CashBook cashBook;
    public HistoryTransaction historyTransaction;

    public Treasurer(String name, int id, String username, String password) {
        super(name, id, username, password);
        this.cashBook = new CashBook();
        this.historyTransaction = new HistoryTransaction();
    }

    public void takingCashNotes(int id, int nominal, String description) {
        cashBook.addCash(nominal);  // Menambah cash ke cashBook
        historyTransaction.addTransaction(new Transaction(id, nominal, description)); // Menambah transaksi ke historyTransaction
    }

    public String viewAllTransactions() {
        StringBuilder transactionsList = new StringBuilder();
        for (Transaction transaction : historyTransaction.getTransactions()) {
            transactionsList.append("ID: ").append(transaction.getId())
                            .append(", Nominal: ").append(transaction.getNominal())
                            .append(", Description: ").append(transaction.getDescription())
                            .append("\n");
        }
        return transactionsList.toString();
    }

    public void viewTransactionByIdString(int id){
        historyTransaction.displayTransactionById(id);
    }     

    
    public String checkTotalCash() {
        return "Total Cash: " + cashBook.CheckTotalCash();
    }
}
