package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Taper nombre des empolye : ");
        Scanner scanner = new Scanner(System.in);
        Personnel personnel = new Personnel(scanner.nextInt());

        Employe employe1 = new Vendeur("abde", "abde", 26, "2016", "info", 1200);
        Employe employe2 = new Manutentionnaire("ahanou", "achraf", 21, "2020", "electrique", 30);
        Employe employe3 = new Technicien("hamane", "ilyas", 20, "2018", "info", 230);

        personnel.ajouterEmploye(employe1);
        personnel.ajouterEmploye(employe2);
        personnel.ajouterEmploye(employe3);

        System.out.println("**************************************************");
        personnel.Enregistrer();
        System.out.println("**************************************************");
        personnel.Afficher();
    }
}
