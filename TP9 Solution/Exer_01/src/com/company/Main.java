package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JTextField textField;
    JButton button;
    JLabel label;

    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();

    public Main() throws HeadlessException {
        setTitle("Concersion Dirham ==> Euro");

        textField = new JTextField(20);
        button = new JButton("Converstion");
        label = new JLabel("0.00 Euro", JLabel.RIGHT);

        panel.setLayout(new FlowLayout());
        panel.add(textField);
        panel.add(button);

        panel1.setLayout(new GridLayout(1, 1));
        panel1.add(label);

        button.addActionListener(this);
        panel.add(panel1);
        add(panel);
        setSize(400, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double m = Math.round((Double.parseDouble(textField.getText()) / 11) * 100.0) / 100.0;
        label.setText((m) + " Euro");
    }
}
