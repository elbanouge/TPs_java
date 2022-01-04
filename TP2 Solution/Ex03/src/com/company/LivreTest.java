package com.company;

public class LivreTest {
    public static void main(String[] args) {
        Livre livre1 = new Livre("Delannoy", "Programmer en Java", 100, 788);
        Livre livre2 = new Livre("Chevallier", "Java 7", 220, 250);

   /*     System.out.println("\n ==> Livre informations :");
        System.out.print(livre1.toString());
        livre1.categoriePrix(livre1);*/

        livre1.setPrix(15);
        livre2.setPrix(45);

    /*    System.out.println("\n ==> Livre informations :");
        System.out.print(livre1.toString());
        livre1.categoriePrix(livre1);

        System.out.println("\n ==> Livre informations :");
        System.out.print(livre2.toString());
        livre2.categoriePrix(livre2);*/

        System.out.println("\n==> Le nombre de livres créés est : " + Livre.getNbLivres());
        System.out.println("==> Le total du nombre de pages dans les 2 livres est : "+(livre1.getNbpages()+livre2.getNbpages()));
    }
}
