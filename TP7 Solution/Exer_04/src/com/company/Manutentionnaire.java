package com.company;

import java.io.Serializable;

public class Manutentionnaire extends Employe implements Serializable {
    private static final double SALAIRE_HORAIRE = 100.00;
    double nombreHeures;

    public Manutentionnaire(String nom, String prenom, int age, String dateEn, String service, double nombreHeures) {
        super(nom, prenom, age, dateEn, service);
        this.nombreHeures = nombreHeures;
    }

    @Override
    public String getTitre() {
        return super.getTitre() + "manutentionnaire";
    }

    @Override
    double calculerSalaireEmployé() {
        return nombreHeures * SALAIRE_HORAIRE;
    }
}
