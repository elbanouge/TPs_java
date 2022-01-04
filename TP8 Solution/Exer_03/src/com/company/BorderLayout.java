package com.company;

import javax.swing.*;
import java.awt.*;

public class BorderLayout extends JFrame {

    JButton button1 = new JButton("Left");
    JButton button2 = new JButton("Right");
    JButton button3 = new JButton("Center");
    JButton button4 = new JButton("Top");
    JButton button5 = new JButton("Bottom");

    public BorderLayout() throws HeadlessException {
        setTitle("BorderLayout");

        add(button1, java.awt.BorderLayout.WEST);
        add(button2, java.awt.BorderLayout.EAST);
        add(button3, java.awt.BorderLayout.CENTER);
        add(button4, java.awt.BorderLayout.NORTH);
        add(button5, java.awt.BorderLayout.SOUTH);

        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayout();
    }

}
