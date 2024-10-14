package Pertemuan3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConversion extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton convertButton;

    public TempConversion() {
        setTitle("Konverter Suhu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel input
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Masukkan suhu (Celsius): "));
        inputField = new JTextField(10);
        inputPanel.add(inputField);
        add(inputPanel, BorderLayout.NORTH);

        // Area output
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Tombol konversi
        convertButton = new JButton("Konversi");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                konversiSuhu();
            }
        });
        add(convertButton, BorderLayout.SOUTH);
    }

    private void konversiSuhu() {
        try {
            double celsius = Double.parseDouble(inputField.getText());
            double fahrenheit = (celsius * 9/5) + 32;
            double reamur = celsius * 4/5;
            double kelvin = celsius + 273.15;

            String hasil = String.format("Hasil konversi:\n" +
                                         "%.2f Celsius = %.2f Fahrenheit\n" +
                                         "%.2f Celsius = %.2f Reamur\n" +
                                         "%.2f Celsius = %.2f Kelvin",
                                         celsius, fahrenheit, celsius, reamur, celsius, kelvin);
            outputArea.setText(hasil);
        } catch (NumberFormatException ex) {
            outputArea.setText("Masukkan angka yang valid!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TempConversion().setVisible(true);
            }
        });
    }
}