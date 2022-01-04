package com.company;

import java.util.Scanner;

public class PalPhrase {

    public static String SupEspace(String mot) {
        String m = "";
        int i = 0;
        char[] mc = mot.toCharArray();

        do {
            if (mc[i] != ' ') {
                m += mc[i];
            }

            i++;
        } while (i < mc.length);

        return m;
    }

    public static void main(String[] args) {

        System.out.println("Taper le mot : ");
        Scanner scanner = new Scanner(System.in);
        String mc = scanner.nextLine();

        System.out.println("Mot sans espace = " + SupEspace(mc));

        PalMot mot = new PalMot();
        System.out.println("Mot inverse = " + mot.inverse(SupEspace(mc)));

        if (mot.inverse(SupEspace(mc)).equals(SupEspace(mc))) {
            System.out.println("Cette mot est palondrome");
        } else {
            System.out.println("Cette mot n'est pas palondrome !!!!!");
        }
    }
}
