package TugasStudiKasus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudyCase {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtStudentName;
    private JTextField txtBookTitle;
    private JRadioButton rbtnBorrow;
    private JRadioButton rbtnReturn;

    public StudyCase() {
        frame = new JFrame("Peminjaman Buku Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Form Input
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Nama Mahasiswa:"));
        txtStudentName = new JTextField();
        panel.add(txtStudentName);

        panel.add(new JLabel("Judul Buku:"));
        txtBookTitle = new JTextField();
        panel.add(txtBookTitle);

        panel.add(new JLabel("Status:"));
        JPanel statusPanel = new JPanel();
        rbtnBorrow = new JRadioButton("Pinjam");
        rbtnReturn = new JRadioButton("Kembali");
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnBorrow);
        group.add(rbtnReturn);
        statusPanel.add(rbtnBorrow);
        statusPanel.add(rbtnReturn);
        panel.add(statusPanel);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitAction());
        panel.add(submitButton);

        frame.add(panel, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"Nama Mahasiswa", "Judul Buku", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class SubmitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String studentName = txtStudentName.getText();
            String bookTitle = txtBookTitle.getText();
            String status = rbtnBorrow.isSelected() ? "Pinjam" : "Kembali";

            if (!studentName.isEmpty() && !bookTitle.isEmpty()) {
                tableModel.addRow(new Object[]{studentName, bookTitle, status});
                txtStudentName.setText("");
                txtBookTitle.setText("");
                rbtnBorrow.setSelected(false);
                rbtnReturn.setSelected(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Silakan isi semua field!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudyCase::new);
    }
}
