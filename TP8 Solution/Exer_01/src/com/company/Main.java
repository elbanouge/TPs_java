package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(String title) throws HeadlessException {
        super(title);

        setSize(400,100);
        setLocationRelativeTo(null);
        //setLocation(150,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new  Main("Un cadre Java");

        JWindow window = new JWindow();
        window.setSize(400,100);
        window.setVisible(true);
    }
}
