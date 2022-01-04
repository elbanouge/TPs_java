package com.company;

import java.io.Serializable;

public class Technicien extends Employe implements Serializable {
    private static final double FACTEUR_UNITE = 5.0;
    double nombreUnites;

    public Technicien(String nom, String prenom, int age, String dateEn, String service, double nombreUnites) {
        super(nom, prenom, age, dateEn, service);
        this.nombreUnites = nombreUnites;
    }

    @Override
    public String getTitre() {
        return super.getTitre() + "technicien";
    }

    @Override
    double calculerSalaireEmployé() {
        return nombreUnites * FACTEUR_UNITE;
    }
}
