package com.company;

import java.io.Serializable;

public class ManutentionnaireARisque extends Manutentionnaire implements Risque, Serializable {

    public ManutentionnaireARisque(String nom, String prenom, int age, String dateEn, String service, double nombreHeures) {
        super(nom, prenom, age, dateEn, service, nombreHeures);
    }

    @Override
    double calculerSalaireEmployé() {
        return super.calculerSalaireEmployé() + PRIME;
    }
}
