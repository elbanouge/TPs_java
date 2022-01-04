package com.company;

import javax.swing.*;
import java.awt.*;

public class GridLayout extends JFrame {
    public GridLayout() throws HeadlessException {
        setTitle("GridLayout");

        this.setLayout(new java.awt.GridLayout(3,2));
        this.getContentPane().add(new JButton("1"));
        this.getContentPane().add(new JButton("2"));
        this.getContentPane().add(new JButton("3"));
        this.getContentPane().add(new JButton("4"));
        this.getContentPane().add(new JButton("5"));

        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayout();
    }
}
