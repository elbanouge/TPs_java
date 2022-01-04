package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JButton button, button2;
    JPanel panel = new JPanel();
    JPanel panelN = new JPanel();
    JPanel panelS = new JPanel();

    public Main() throws HeadlessException {
        setTitle("Les événements");
        panelN.setBackground(Color.ORANGE);
        button = new JButton("Bleu");
        button2 = new JButton("Vert");

        panel.setLayout(new BorderLayout());
        panel.add(panelN, BorderLayout.CENTER);
        panel.add(panelS, BorderLayout.SOUTH);

        panelS.add(button);
        panelS.add(button2);
        add(panel);

        button.addActionListener(this);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelN.setBackground(Color.GREEN);
            }
        });

        setSize(500,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panelN.setBackground(Color.BLUE);
    }
}
