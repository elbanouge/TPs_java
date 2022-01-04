package com.company;

import javax.swing.*;
import java.awt.*;

public class FlowLayout extends JFrame {

    private JButton button1 = new JButton("Button1");
    private JButton button2 = new JButton("Button2");
    private JButton button3 = new JButton("Button3");
    private JButton button4 = new JButton("Button4");

    private JPanel panel = new JPanel();

    public FlowLayout() throws HeadlessException {
        setTitle("FlowLayout");
        add(panel);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        setSize(300,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayout();
    }
}
