package com.company;

import java.util.Date;

public abstract class Employe {
    private String nom, prenom;
    private int age;
    private String dateEn;
    private String service;

    public Employe(String nom, String prenom, int age, String dateEn, String service) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateEn = dateEn;
        this.service = service;
    }

    public String getTitre() {
        return "L’employé ";
    }

    @Override
    public String toString() {
        return "==> " + getTitre() + '\n' +
                "Nom : " + nom + '\n' +
                "Prénom : " + prenom + '\n' +
                "Age : " + age + '\n' +
                "Date d'entrée : " + dateEn + '\n' +
                "Service : " + service + '\n';
    }

    abstract double calculerSalaireEmployé();
}
