package com.company;

public class TitreException extends Exception {
    public TitreException() {
        System.out.println("Vous avez saisie un titre du livre dont la longueur est inférieure à 3 caractères !!!!");
    }
}
