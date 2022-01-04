package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nombres = {10, 20, 15, 2, 50, 11};
        int max = nombres[0], min = nombres[0], indMax = 0, indMin = 0;
        int somme = nombres[0];

        for (int i = 1; i < nombres.length; i++) {
            if (max < nombres[i]) {
                max = nombres[i];
                indMax = i;
            }
            if (min > nombres[i]) {
                min = nombres[i];
                indMin = i;
            }
            somme += nombres[i];
        }

        float moy = somme / nombres.length;
        int nSupM = 0;
        int nInfM = 0;

        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i] >= moy) {
                nSupM++;
            } else {
                nInfM++;
            }
        }

        System.out.println("La plus grande valeur est : " + max + " et elle se trouve à l'indice : " + indMax);
        System.out.println("La plus petite valeur est : " + min + " et elle se trouve à l'indice : " + indMin);
        System.out.println("La moyenne de ces valeurs est : " + moy);
        System.out.println("Nombre de valeurs supérieures ou égales à la moyenne est : " + nSupM);
        System.out.println("Nombre de valeurs inférieures à la moyenne est : " + nInfM);

    }
}
