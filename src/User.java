package src;

public class User {
    private String name;
    private int id;
    private Account account;
    public User(String name, int id) {
        this.name = name;
        this.id = id;
        account = new Account(name, id);
    }

    public int CheckTotalCash(CashBook cashBook){ 
        return cashBook.totalCash;
    }
    public int payFund(int nominal){
        return nominal;
    }
}
