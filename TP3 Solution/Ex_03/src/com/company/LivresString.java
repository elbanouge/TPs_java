package com.company;

import java.util.Scanner;

public class LivresString {


    public static void remplir(String[][] mat, int max) {

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (j == 0) {
                    System.out.println("Taper le auteur de livre :");
                    Scanner scanner2 = new Scanner(System.in);
                    String auteur = scanner2.next();

                    mat[i][j] = auteur;
                }
                if (j == 1) {
                    System.out.println("Taper le titre de livre :");
                    Scanner scanner3 = new Scanner(System.in);
                    String titre = scanner3.next();

                    mat[i][j] = titre;

                }
                if (j == 2) {
                    System.out.println("Taper le domaine de livre :");
                    Scanner scanner4 = new Scanner(System.in);
                    String domaine = scanner4.next();

                    mat[i][j] = domaine;
                }
            }
        }
    }

    public static void afficher(String[][] mat) {
        System.out.println("-----------------------------");
        System.out.println("| Auteur \t | Titre \t | Domaine|");
        System.out.println("-----------------------------");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("| " + mat[i][j] + "\t");
            }
            System.out.println(" |");
            System.out.println("-----------------------------");
        }
    }

    public static boolean recherche(String[][] mat, String motRch) {
        boolean bol = false;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][1].equals(motRch) || mat[i][0].indexOf(motRch) != -1) {
                    bol = true;
                    break;
                }
            }
        }

        return bol;
    }

    public static void menu() {
        int choix = 0;

        int Maxlivres = 12;

        System.out.println("Taper le nombre des livres :");
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();

        String[][] matrice = new String[max][3];

        if (Maxlivres > max) {

            do {
                System.out.println("____________________");
                System.out.println("| Bonjour Abdellah |");
                System.out.println("____________________");
                System.out.println();
                System.out.println();
                System.out.println("1- Remplir les livres.");
                System.out.println("2- recherche les livres.");
                System.out.println("3- afficher les livres.");
                System.out.println("4- Quiter.");
                System.out.println();
                System.out.println("* Taper votre choix *");
                Scanner scanner3 = new Scanner(System.in);
                choix = scanner3.nextInt();

                switch (choix) {
                    case 1:

                        remplir(matrice, max);
                        break;
                    case 2:

                        System.out.println("Taper le titre de livre recherche :");
                        Scanner scanner1 = new Scanner(System.in);
                        String rechL = scanner1.nextLine();

                        boolean b1 = recherche(matrice, rechL);

                        if (b1 == true) {
                            System.out.println("Titre livre recherche existe.");
                        } else {
                            System.out.println("livre recherche n'existe pas !!!");
                        }

                        System.out.println("Taper le auteur de livre recherche :");
                        Scanner scanner2 = new Scanner(System.in);
                        String rechA = scanner2.nextLine();

                        boolean b2 = recherche(matrice, rechA);
                        if (b2 == true) {
                            System.out.println("Auteur de livre recherche existe.");
                        } else {
                            System.out.println("Auteur de livre recherche n'existe pas !!!");
                        }
                        break;
                    case 3:

                        afficher(matrice);
                        break;
                    default:
                        break;
                }
            } while (choix != 4);

        } else {
            System.out.println("Vous avez depassez le nombre des livres disponible !!!!");
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
