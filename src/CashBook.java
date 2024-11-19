package src;

import java.util.LinkedList;

public class CashBook {
    // Deklarasikan atribut list pada tingkat kelas
    int totalCash;
    int totalUserCash;
    LinkedList<String> list;

    // Constructor untuk inisialisasi
    public CashBook() {
        list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
    }
}
