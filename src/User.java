package src;

public class User {
    private String name;
    private String studentID;
    private Account account;

    public User(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        account = new Account(name, studentID);
    }

    public void CheckClassCash(){
        
    }

    public void CheckIndividualCash(){

    }
}
