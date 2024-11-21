package src;

public class Main {
    public static void main(String[] args) {
        Treasurer treasurer = new Treasurer("John Treasurer", 1, "treasurer123", "password123");
        Student student = new Student("Jane Student", 2, "student123", "password123");

        new LoginGUI(treasurer, student).setVisible(true);
    }
}
