package src;
import java.util.LinkedList;

public class contohList {

    // Main driver method
    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<String> list = new LinkedList<String>();

        // Adding elements to the LinkedList using add() method
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        // Printing the LinkedList
        System.out.println(list);
    }
}
