package com.company;

public class Representant extends Commercial  {
    private static final double POURCENT_REPRESENTANT = 0.3;
    private static final double BONUS_REPRESENTANT = 1000;

    public Representant(String nom, String prenom, int age, String dateEn, String service, double chiffreAffaire) {
        super(nom, prenom, age, dateEn, service, chiffreAffaire);
    }

    @Override
    public String getTitre() {
        return super.getTitre() + "repr√©sentant";
    }

    @Override
    double calculerSalaireEmploy√©() {
        return this.getChiffreAffaire() * POURCENT_REPRESENTANT + BONUS_REPRESENTANT;
    }
}
