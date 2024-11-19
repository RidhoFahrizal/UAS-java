package src;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard extends JFrame {
    public StudentDashboard() {
        setTitle("Student Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Selamat datang, Student!");
        welcomeLabel.setBounds(10, 10, 200, 25);
        panel.add(welcomeLabel);

        JButton checkBalanceButton = new JButton("Lihat Saldo");
        checkBalanceButton.setBounds(10, 50, 150, 25);
        panel.add(checkBalanceButton);

        JButton payButton = new JButton("Bayar Uang Kas");
        payButton.setBounds(10, 90, 150, 25);
        panel.add(payButton);

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Saldo kamu: Rp 50,000");
            }
        });

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pembayaran berhasil!");
            }
        });

        add(panel);
    }
}
