package anykeyspace.hashcalculator;

import javax.swing.*;
import java.awt.*;
import java.security.NoSuchAlgorithmException;

import static anykeyspace.hashcalculator.Calculator.calculateHash;

public class HashCalculatorGUI extends JFrame {
    private JButton button = new JButton("calculate");
    private JTextField input = new JTextField("", 30);
    private JTextField output = new JTextField("", 100);

    public HashCalculatorGUI() {
        super("Hash calculator");
        this.setBounds(700, 200, 800, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 1, 1, 1));
        container.add(input);

        button.addActionListener(e -> {
            String value = input.getText().replaceAll("\\s+", "");

            try {
                output.setText(calculateHash(value));
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
        });
        container.add(button);

        output.setEditable(false);
        container.add(output);
    }

    public static void main(String[] args) {
        HashCalculatorGUI app = new HashCalculatorGUI();
        app.setVisible(true);
    }
}