package com.company;

public class Manutentionnaire extends Employe {
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
        return 1 * SALAIRE_HORAIRE;
    }
}
