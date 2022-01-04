package com.company;

import javax.swing.*;
import java.awt.*;

public class Formulaire extends JFrame {
    private JButton button1 = new JButton("Sud");
    private JButton button2 = new JButton("Center");
    private JButton button3 = new JButton("Est");

    private JButton button4 = new JButton("Top");
    private JButton button5 = new JButton("Bottom");

    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();
    private JPanel panel6 = new JPanel();

    public Formulaire() throws HeadlessException {
        setTitle("Formulaire d'inscription");

        /* Pannel 1 */
        panel.setLayout(new BorderLayout());
        //panel.add(button1, BorderLayout.SOUTH);
        panel.add(panel6, BorderLayout.SOUTH);
        panel.add(panel2);
        panel.add(panel4, BorderLayout.EAST);
        //panel.add(button3, BorderLayout.EAST);
        this.add(panel);

        /* Pannel 2 */
        panel2.setLayout(new BorderLayout());

        //panel2.add(button4, BorderLayout.NORTH);
        panel2.add(button2, BorderLayout.CENTER);
        panel2.add(panel3, BorderLayout.NORTH);
        //panel2.add(button5, BorderLayout.SOUTH);
        panel2.add(panel5, BorderLayout.SOUTH);

        panel3.setLayout(new GridLayout(5,1));
        panel3.add(new JButton("Nom"));
        panel3.add(new JButton("Nom"));
        panel3.add(new JButton("Nom"));
        panel3.add(new JButton("Nom"));
        panel3.add(new JButton("Nom"));

        panel4.setLayout(new GridLayout(4,1));
        panel4.add(new JButton("Nom"));
        panel4.add(new JButton("Nom"));
        panel4.add(new JButton("Nom"));
        panel4.add(new JButton("Nom"));

        panel5.setLayout(new FlowLayout());
        panel5.add(new JButton("Nom"));
        panel5.add(new JButton("Nom"));

        panel6.setLayout(new FlowLayout());
        panel6.add(new JButton("Nom"));
        panel6.add(new JButton("Nom"));

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Formulaire();
    }
}
