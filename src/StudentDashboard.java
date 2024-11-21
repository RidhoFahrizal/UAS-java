package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard extends JFrame {
    private Student student;
    private Treasurer treasurer;
    private JLabel totalCashLabel; // Label untuk saldo

    public StudentDashboard(Student student, Treasurer treasurer) {
        this.student = student;
        this.treasurer = treasurer;

        setTitle("Student Dashboard");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // Menggunakan BorderLayout untuk tata letak utama

        // Panel untuk menampilkan saldo
        JPanel balancePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        balancePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        totalCashLabel = new JLabel( treasurer.checkTotalCash());
        totalCashLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balancePanel.add(totalCashLabel);

        // Panel utama untuk tombol
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton payFundButton = new JButton("Pay Fund");
        JButton viewTransactionByIdButton = new JButton("View Transaction by ID");
        mainPanel.add(payFundButton);
        mainPanel.add(viewTransactionByIdButton);

        // Tambahkan panel ke frame
        add(balancePanel, BorderLayout.NORTH); // Panel saldo di atas
        add(mainPanel, BorderLayout.CENTER);   // Panel utama di tengah

        // Aksi untuk tombol "Pay Fund"
        payFundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Enter User ID:");
                String nominalStr = JOptionPane.showInputDialog("Enter Nominal:");
                String description = JOptionPane.showInputDialog("Enter Description:");

                if (idStr != null && nominalStr != null && description != null) {
                    try {
                        int id = Integer.parseInt(idStr);
                        int nominal = Integer.parseInt(nominalStr);
                        treasurer.takingCashNotes(id, nominal, description);
                        JOptionPane.showMessageDialog(null, "Payment successful! Transaction added.");
                        updateTotalCash(); // Perbarui saldo setelah pembayaran
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter numbers for ID and Nominal.");
                    }
                }
            }
        });

        // Aksi untuk tombol "View Transaction by ID"
        viewTransactionByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Enter Transaction ID:");
                if (idStr != null) {
                    try {
                        int id = Integer.parseInt(idStr);
                        treasurer.viewTransactionByIdString(id);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number for Transaction ID.");
                    }
                }
            }
        });
    }

    // Method untuk memperbarui saldo di label
    private void updateTotalCash() {
        totalCashLabel.setText("Total Cash: " + treasurer.checkTotalCash());
    }
}
