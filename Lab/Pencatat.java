public class Pencatat {
    private CatatanTransaksi catatan = new CatatanTransaksi(); 
   
    
    public void mencatat(int id, int nominal, String keterangan){
        catatan.tambahTransaksi(id, nominal, keterangan);
    }

    public void  viewAllTransaction(){
        catatan.displayAllTransaction();
    }

    public void viewTranscationById(int id){
        catatan.displayTransactionById(id);
    }
}
