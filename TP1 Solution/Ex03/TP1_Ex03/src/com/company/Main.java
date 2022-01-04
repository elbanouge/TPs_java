package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] matrice = {{1, 2, 3}, {6, 5, 12}, {6, 8, 6}};

        int r = 6;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if (matrice[i][j] == r) {
                    System.out.println("6 trouvé à la ligne:" + i);
                    j = matrice.length;
                    continue;
                }
            }
        }
    }
}
