package com.company;

import java.io.Serializable;

public class Personne implements Serializable {
    transient private String nom, prenom;
    private int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Personne : " +
                " nom = " + getNom() +
                " prenom = " + getPrenom() +
                " age = " + getAge();
    }
}
