package src;

public class Treasurer extends User{

   CashBook cashBook = new CashBook();
   HistoryTransaction historyTransaction = new HistoryTransaction();
   public Treasurer(String name, int id){
   super(name, id);
   } 

   public void takingCashNotes(int id, int nominal, String description ){
      cashBook.addCash(nominal);
      
      
   }

   public void viewAllTransaction(){

   }

   public void viewTransactionById(){

   }
}
