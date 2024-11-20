package src;

public class Treasurer extends User{

   CashBook cashBook = new CashBook();
   HistoryTransaction historyTransaction = new HistoryTransaction();
   public Treasurer(String name, int id,String username, String password ){
      super(name, id, username, password);
   } 

   public void takingCashNotes(int id, int nominal, String description ){
      cashBook.addCash(nominal);
      
      
   }
/* 
   public void viewAllTransaction(){

   }

   public void viewTransactionById(){

   }

*/
}
