package src;

public class User {
    private String name;
    private int id;
    private Account account;
    public User(String name, int id, String username, String password) {
        this.name = name;
        this.id = id;
        account = new Account(username, password);
    }

  
    public int payFund(int nominal){
        return nominal;
    }

    public String getName() {
        return name;
    }

    public int getid() {
        return id;
    }

    public Account getAccount(){
        return this.account;
    }
}
