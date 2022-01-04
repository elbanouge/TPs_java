package com.company;

import java.io.Serializable;

public class TechnicienARisque extends Technicien implements Risque, Serializable {

    public TechnicienARisque(String nom, String prenom, int age, String dateEn, String service, double nombreUnites) {
        super(nom, prenom, age, dateEn, service, nombreUnites);
    }

    @Override
    double calculerSalaireEmployé() {
        return super.calculerSalaireEmployé() + PRIME;
    }
}
