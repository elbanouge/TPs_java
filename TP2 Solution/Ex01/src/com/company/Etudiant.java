package com.company;

public class Etudiant {

    private String nom;
    private String prenom;
    private int cne;

    public Etudiant(String Nom, String Prenom) {
        this.nom = Nom;
        this.prenom = Prenom;
    }

    public Etudiant(String Nom, String Prenom, int CNE) {
        this(Nom, Prenom);
        this.cne = CNE;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getCNE() {
        return cne;
    }

    public void SetCNE(int CNE) {
        this.cne = CNE;
    }

    @Override
    public String toString() {
        return "Les informations de ce etudiant sont :" +
                "\n Nom : " + getNom() +
                "\n Prenom : " + getPrenom() +
                "\n CNE : " + getCNE();
    }
}
