package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LivresGestion {
    private Livre tab[];
    public LivresGestion(int n) {
        tab = new Livre[n];
    }

    public void remplir() {
        try {
            int i = 0;
            do {
                System.out.println("Taper auteur de livre : ");
                Scanner scanner = new Scanner(System.in);
                String auteur = scanner.next();

                System.out.println("Taper titre de livre : ");
                Scanner scanner1 = new Scanner(System.in);
                String titre = scanner1.next();

                if (titre.length() < 3) {
                    throw new InputMismatchException();
                }
                System.out.println("Taper prix de livre : ");
                Scanner scanner2 = new Scanner(System.in);
                float prix = scanner2.nextFloat();
                if (prix < 0) {
                    throw new InputMismatchException();
                }

                System.out.println("Taper nombre des pages de livre : ");
                Scanner scanner3 = new Scanner(System.in);
                int nombreP = scanner3.nextInt();

                tab[i] = new Livre(auteur, titre, prix, nombreP);
                i++;
            } while (i < tab.length);

        } catch (InputMismatchException exception) {
            exception.printStackTrace();
        }
    }

    public void afficher_livres() {
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i].toString());
        }
    }

    public void afficher_NbLivres() {
        System.out.println("Le nombre des livres crées est : " + Livre.getNbLivres());
    }

    public void rechercher_livres(String Rch) {
        int indice = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getAuteur().contains(Rch)) {
                System.out.println("- Auteur : " + tab[i].getAuteur());
                System.out.println("le autheur recherche existe");
                indice = 1;
            } else if (tab[i].getTitre().equals(Rch)) {
                System.out.println("- Titre : " + tab[i].getTitre());
                System.out.println("le titre recherche existe");
                indice = 1;
            }
        }

        if (indice == 0) {
            System.out.println("le titre ou le autheur recherche n'existe pas !!!!");
        }
    }

    public void menu() {

        int choix = 0;

        do {
            System.out.println("____________________");
            System.out.println("| Bonjour Abdellah |");
            System.out.println("____________________");
            System.out.println();
            System.out.println("1- Remplir les livres.");
            System.out.println("2- afficher les livres.");
            System.out.println("3- afficher nombres des livres.");
            System.out.println("4- recherche les livres.");
            System.out.println("5- Quiter.");
            System.out.println();
            System.out.println("* Taper votre choix *");
            Scanner scanner1 = new Scanner(System.in);
            choix = scanner1.nextInt();

            switch (choix) {
                case 1:
                    remplir();
                    break;
                case 2:
                    afficher_livres();
                    break;
                case 3:
                    afficher_NbLivres();
                    break;
                case 4:
                    System.out.println("Taper le autheur ou le titre de livre recherche : ");
                    Scanner scanner2 = new Scanner(System.in);
                    String rch = scanner2.nextLine();
                    rechercher_livres(rch);
                    break;
                default:
                    break;
            }
        } while (choix != 5);
    }
}
