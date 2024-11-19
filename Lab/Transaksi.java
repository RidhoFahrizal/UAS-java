public class Transaksi {
   int id;
   int nominal;
   String keterangan;
      
   // Karena obyek tidak boleh sama, maka kita akan menggunakan obyek dari Student untuk data nya 
   
  public  Transaksi(int id, int nominal, String keterangan){
        this.id = id;
        this.nominal = nominal;
        this.keterangan = keterangan;
   }

   public Transaksi(){
         
   }
}
