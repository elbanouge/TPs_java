package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] triangle = new int[100][100];
        int n = 0;
        do {
            System.out.println("Taper la valeur de Triangle de Pascal : ");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();

        } while (n < 0);

        for (int i = 0; i < n; i++) {
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            for (int j = 1; j < i; j++) {
                triangle[i][j] = (triangle[i - 1][j - 1]) + (triangle[i - 1][j]);
            }
        }

        System.out.println("Triangle de Pascal pour une valeur de n = " + n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j]);
            }
            System.out.println();
        }
    }
}
