package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntException {
    public int SaisieInt() {
        boolean bol = false;
        int val = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Taper la valeur de n : ");
                val = scanner.nextInt();
                bol = true;
            } catch (InputMismatchException e) {
                String s = scanner.nextLine();
            }
        } while (bol == false);

        return val;
    }
}
