package src;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi akun untuk login
        Account treasurerAccount = new Account("treasurer", "1234");
        Account studentAccount = new Account("student", "1234");

        // Inisialisasi pengguna
        Treasurer treasurer = new Treasurer("Treasurer Name", 1, "treasurer", "1234");
        Student student = new Student("Student Name", 2, "student", "1234");

        // Menjalankan GUI dalam thread event dispatcher
        SwingUtilities.invokeLater(() -> {
            // Menampilkan halaman login
            new LoginGUI().setVisible(true);
        });
    }
}
