package com.company;

import java.util.Scanner;

public class motDePasse {
    private String pwrd;

    public static int i = 0;

    public motDePasse() {
        System.out.println("Taper mode passe de l'employe : " + (i + 1));
        Scanner scanner = new Scanner(System.in);
        String pwd = scanner.nextLine();

        this.pwrd = pwd;
        motDePasse.i += 1;
    }

    public String getPwrd() {
        return pwrd;
    }
}
