package com.company;

import javax.swing.*;
import java.awt.*;

public class Cadre extends JFrame {
    public Cadre(String title) throws HeadlessException {
        super(title);
        setSize(400, 150);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-(this.getWidth()/2);
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-(this.getHeight()/2);
        setBounds(x, y, this.getWidth(), this.getHeight());

        //setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("..\\Exer_02\\icon.png");
        setIconImage(img.getImage());
        setResizable(false);

        JPanel panel = new JPanel();
        JButton button = new JButton("OK");
        panel.setBackground(Color.ORANGE);

        panel.add(button);
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Cadre("Cadre centre a l'ecran.");
    }
}
