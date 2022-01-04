package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String nom = "", s_age="";
        int age;
        nom= JOptionPane.showInputDialog("Quel est votre nom?");
        s_age=JOptionPane.showInputDialog("Quel âge avez vous?");
        age=Integer.parseInt(s_age);
        String msg = "Salam "+nom+". Vous avez: " + (age)+ " ans.";
        JOptionPane.showMessageDialog(null, msg);
    }
}
