package com.company;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JLabel label1, label2, label3, label4, label5;
    JTextField textField1, textField2;
    JRadioButton radioButtonM, radioButtonF;
    JComboBox boxD, boxM, boxA;
    JTextArea areaAdrs;
    JCheckBox checkBoxTerms;
    JButton submit;
    JLabel msg;

    public MyFrame() throws HeadlessException {
        setTitle("Regestration Form");
        setSize(700, 500);

        Container container = getContentPane();
        container.setLayout(null);
        label1 = new JLabel("Name : ");
        label1.setBounds(20, 50, 100, 20);
        container.add(label1);

        textField1 = new JFormattedTextField();
        textField1.setBounds(130, 50, 100, 20);
        container.add(textField1);

        label2 = new JLabel("Mobile : ");
        label2.setBounds(20, 100, 100, 20);
        container.add(label2);

        textField2 = new JFormattedTextField();
        textField2.setBounds(130, 100, 100, 20);
        container.add(textField2);

        label3 = new JLabel("Gender : ");
        label3.setBounds(20, 150, 100, 20);
        container.add(label3);

        radioButtonM = new JRadioButton("Male");
        radioButtonM.setBounds(130, 150, 100, 20);
        radioButtonF = new JRadioButton("Female");
        radioButtonF.setBounds(250, 150, 100, 20);

        radioButtonF.setSelected(true);
        container.add(radioButtonF);
        container.add(radioButtonM);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonF);
        group.add(radioButtonM);

        label4 = new JLabel("Date : ");
        label4.setBounds(20, 200, 100, 20);
        container.add(label4);

        String[] sD = {"1", "2", "3", "4"};
        String[] sM = {"janv", "mars", "mai", "december"};
        String[] sA = {"1999", "2001", "2003", "2004"};

        boxD = new JComboBox(sD);
        boxD.setBounds(130, 200, 50, 20);
        boxM = new JComboBox(sM);
        boxM.setBounds(200, 200, 60, 20);
        boxA = new JComboBox(sA);
        boxA.setBounds(280, 200, 60, 20);

        container.add(boxD);
        container.add(boxM);
        container.add(boxA);

        label5 = new JLabel("Adresse : ");
        label5.setBounds(20, 250, 100, 20);
        container.add(label5);

        areaAdrs = new JTextArea();
        areaAdrs.setBounds(130, 250, 200, 100);
        container.add(areaAdrs);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
