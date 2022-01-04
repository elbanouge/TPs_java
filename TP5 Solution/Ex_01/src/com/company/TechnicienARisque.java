package com.company;

public class TechnicienARisque extends Technicien implements Risque {

    public TechnicienARisque(String nom, String prenom, int age, String dateEn, String service, double nombreUnites) {
        super(nom, prenom, age, dateEn, service, nombreUnites);
    }

    @Override
    double calculerSalaireEmployé() {
        return super.calculerSalaireEmployé() + PRIME;
    }
}
