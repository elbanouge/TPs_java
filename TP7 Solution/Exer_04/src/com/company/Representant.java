package com.company;

import java.io.Serializable;

public class Representant extends Commercial implements Serializable {
    private static final double POURCENT_REPRESENTANT = 0.3;
    private static final double BONUS_REPRESENTANT = 1000;

    public Representant(String nom, String prenom, int age, String dateEn, String service, double chiffreAffaire) {
        super(nom, prenom, age, dateEn, service, chiffreAffaire);
    }

    @Override
    public String getTitre() {
        return super.getTitre() + "représentant";
    }

    @Override
    double calculerSalaireEmployé() {
        return this.getChiffreAffaire() * POURCENT_REPRESENTANT + BONUS_REPRESENTANT;
    }
}
