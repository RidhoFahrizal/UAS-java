package src;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TreasurerDashboard extends JFrame {
    public TreasurerDashboard() {
        setTitle("Treasurer Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Selamat datang, Treasurer!");
        welcomeLabel.setBounds(10, 10, 200, 25);
        panel.add(welcomeLabel);

        JButton viewTransactionsButton = new JButton("Lihat Transaksi");
        viewTransactionsButton.setBounds(10, 50, 150, 25);
        panel.add(viewTransactionsButton);

        JButton addTransactionButton = new JButton("Tambah Transaksi");
        addTransactionButton.setBounds(10, 90, 150, 25);
        panel.add(addTransactionButton);

        viewTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Daftar Transaksi:\n1. Uang Masuk: Rp 50,000\n2. Uang Keluar: Rp 20,000");
            }
        });

        addTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Transaksi baru berhasil ditambahkan!");
            }
        });

        add(panel);
    }
}
