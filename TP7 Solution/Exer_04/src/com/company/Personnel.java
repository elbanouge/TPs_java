package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Personnel implements Serializable {
    public ArrayList<Employe> employeList;
    public int nbEmployes;
    private static final int MAX_EMPLOYES = 87;

    public Personnel(int n) {
        if (MAX_EMPLOYES < n) {
            System.out.println("Vous avez depassé la capacite des livres disponible !!!");
        } else {
            employeList = new ArrayList<>(n);
        }
    }

    public void ajouterEmploye(Employe e) {
        employeList.add(e);
    }

    public void afficherSalaires() {
        for (Employe employe : employeList) {
            System.out.println(employe.toString() + "\n Salaire = " + employe.calculerSalaireEmployé());
        }
    }

    public void Enregistrer() {
        try {
            File file = new File("Employes.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            objectOutputStream.writeObject(employeList);
            objectOutputStream.close();

            System.out.println("Employe ajoute au fichier avec sucees.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Afficher() {

        try {
            File file = new File("Employes.txt");
            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));


            System.out.println("Lecteur de fichier text : ");
            for (Employe employe : (ArrayList<Employe>) inputStream.readObject()) {
                System.out.println("**************************************************");
                System.out.println(employe.toString());
            }
            inputStream.close();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public double salaireMoyen() {
        double salaireM = 0;
        for (Employe employe : employeList) {
            salaireM += employe.calculerSalaireEmployé();
        }
        return salaireM/employeList.size();
    }
}
