package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardGUI extends JFrame {
    private boolean isTreasurer;
    private HistoryTransaction historyTransaction;
    private CashBook cashBook;

    public DashboardGUI(boolean isTreasurer) {
        this.isTreasurer = isTreasurer;
        this.historyTransaction = new HistoryTransaction();
        this.cashBook = new CashBook();

        setTitle(isTreasurer ? "Treasurer Dashboard" : "Student Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Label judul
        JLabel titleLabel = new JLabel(isTreasurer ? "Treasurer Dashboard" : "Student Dashboard", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Tombol utama
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton viewTransactionsButton = new JButton("View Transactions");
        JButton addTransactionButton = new JButton("Add Transaction");
        JButton checkCashButton = new JButton("Check Total Cash");

        if (isTreasurer) {
            buttonPanel.add(addTransactionButton);
        }
        buttonPanel.add(viewTransactionsButton);
        buttonPanel.add(checkCashButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        // Event listeners
        viewTransactionsButton.addActionListener(e -> viewTransactions());
        addTransactionButton.addActionListener(e -> {
            if (isTreasurer) {
                addTransaction();
            }
        });
        checkCashButton.addActionListener(e -> checkCash());

        add(panel);
    }

    private void viewTransactions() {
        StringBuilder sb = new StringBuilder("All Transactions:\n");
        for (Transaction transaction : historyTransaction.getTransactions()) {
            sb.append(transaction).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void addTransaction() {
        String idStr = JOptionPane.showInputDialog(this, "Enter Transaction ID:");
        String nominalStr = JOptionPane.showInputDialog(this, "Enter Nominal:");
        String description = JOptionPane.showInputDialog(this, "Enter Description:");

        if (idStr != null && nominalStr != null && description != null) {
            try {
                int id = Integer.parseInt(idStr);
                int nominal = Integer.parseInt(nominalStr);

                historyTransaction.addTransaction(new Transaction(id, nominal, description));
                cashBook.addCash(nominal);

                JOptionPane.showMessageDialog(this, "Transaction added successfully!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Transaction not added.");
            }
        }
    }

    private void checkCash() {
        JOptionPane.showMessageDialog(this, cashBook.toString());
    }
}
