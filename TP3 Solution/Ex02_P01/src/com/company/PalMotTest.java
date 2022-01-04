package com.company;

import java.util.Scanner;

public class PalMotTest {

    public static void main(String[] args) {

        PalMot mot = new PalMot();

        System.out.println("Taper le mot : ");
        Scanner scanner = new Scanner(System.in);
        String mo = scanner.next();

        System.out.println("Mot inverse = " + mot.inverse(mo));

        if (mot.testpalidrome(mo)) {
            System.out.println("Le mot est palidrome.");
        }
        else {
            System.out.println("Le mot n'est pas palidrome.");
        }

    }
}
