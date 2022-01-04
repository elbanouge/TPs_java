package com.company;

public class Vendeur extends Commercial {
    private static final double POURCENT_VENDEUR = 0.2;
    private static final double BONUS_VENDEUR = 670;

    public Vendeur(String nom, String prenom, int age, String dateEn, String service, double chiffreAffaire) {
        super(nom, prenom, age, dateEn, service, chiffreAffaire);
    }

    @Override
    public String getTitre() {
        return super.getTitre() + "vendeur";
    }

    @Override
    double calculerSalaireEmployé() {
        return this.getChiffreAffaire() * POURCENT_VENDEUR + BONUS_VENDEUR;
    }
}
