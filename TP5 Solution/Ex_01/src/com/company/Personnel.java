package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Personnel {
    public ArrayList<Employe> employeList;
    public int nbEmployes;
    private static final int MAX_EMPLOYES = 87;

    public Personnel(int n) {
        if (MAX_EMPLOYES < n) {
            System.out.println("Vous avez depass√© la capacite des livres disponible !!!");
        } else {
            employeList = new ArrayList<>(n);
        }
    }

    public void ajouterEmploye(Employe e) {
        try {
            employeList.add(e);
        } catch (InputMismatchException exception) {
            exception.printStackTrace();
        }
    }

    public void afficherSalaires() {
        for (Employe employe : employeList) {
            System.out.println(employe.toString() + "Salaire = " + employe.calculerSalaireEmploy√©() + " \n");
        }
    }

    public double salaireMoyen() {
        double salaireM = 0;
        for (Employe employe : employeList) {
            salaireM += employe.calculerSalaireEmploy√©();
        }

        salaireM = salaireM / employeList.size();
        double salaireMoy = Math.round(salaireM * 100) / 100.00;
        return salaireMoy;
    }
}
