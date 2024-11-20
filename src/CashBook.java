package src;


public class CashBook {

    private int totalCash;

    public int CheckTotalCash (){
        return this.totalCash;
    }

    public void addCash(int nominal){
        totalCash += nominal;
    }
    public String toString() {
        return "Total Cash: " + totalCash;
    }
}
