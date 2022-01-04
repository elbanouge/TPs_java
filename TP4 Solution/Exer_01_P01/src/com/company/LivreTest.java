package com.company;

import java.util.Scanner;

public class LivreTest {
    public static void main(String[] args) {

        System.out.println("Taper le nombre des livres :");
        Scanner scanner = new Scanner(System.in);
        int nb = scanner.nextInt();

        if (Livre.MAX_LIVRES > nb) {

            LivresGestion livresGestion = new LivresGestion(nb);
            livresGestion.menu();
        } else {
            System.out.println("Vous avez depassez le nombre des livres disponible !!!!");
        }
    }
}
