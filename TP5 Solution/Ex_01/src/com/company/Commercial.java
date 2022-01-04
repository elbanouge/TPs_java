package com.company;

public class Commercial extends Employe {
    private double chiffreAffaire;

    public Commercial(String nom, String prenom, int age, String dateEn, String service, double chiffreAffaire) {
        super(nom, prenom, age, dateEn, service);
        this.chiffreAffaire = chiffreAffaire;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    @Override
    double calculerSalaireEmployé() {
        return 0;
    }
}
