package com.company;

public class PrixException extends Exception {
    public PrixException() {
        System.out.println("Vous avez saisir un prix de livre négatif !!!!!!!!!!");
    }
}
