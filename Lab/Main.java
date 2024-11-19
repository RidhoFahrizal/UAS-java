
public class Main {

     public static void main(String[] args) {
        Pencatat pencatat = new Pencatat();
        pencatat.mencatat(1, 2000, "BAYAAAA");
        pencatat.mencatat(2, 3000, "Catatan ID ke 2");
        pencatat.mencatat(4, 2000, "BAYAAAA");
        pencatat.mencatat(3, 2000, "BAYAAAA");

        pencatat.viewAllTransaction();
        pencatat.viewTranscationById(2);
     }
}