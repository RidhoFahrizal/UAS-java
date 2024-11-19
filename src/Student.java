package src;

public class Student extends User{
   
    public Student(String name, int id, String username , String password ){
        super(name, id, username, password);
        
    }

    public void viewHistoryTransaction(HistoryTransaction historyTransaction, int id){
        historyTransaction.displayTransactionById(id);
   }
}
