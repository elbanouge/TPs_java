package com.company;

import java.io.Serializable;

public abstract class Employe extends motDePasse implements Serializable {
    private String nom, prenom;
    private int age;
    private String dateEn;
    private String service;
    transient private String pwd;

    public Employe(String nom, String prenom, int age, String dateEn, String service) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateEn = dateEn;
        this.service = service;
        pwd = getPwrd();
    }

    public String getTitre() {
        return "L’employé ";
    }

    @Override
    public String getPwrd() {
        return super.getPwrd();
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", dateEn='" + dateEn + '\'' +
                ", service='" + service + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    abstract double calculerSalaireEmployé();
}
