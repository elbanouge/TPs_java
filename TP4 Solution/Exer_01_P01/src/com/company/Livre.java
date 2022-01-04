package com.company;

public class Livre {

    private String auteur;
    private String titre;
    private float prix;
    private int NbPages;
    private static int NbLivres = 0;
    public static final int MAX_LIVRES = 12;

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public int getNbPages() {
        return NbPages;
    }

    public float getPrix() {
        return prix;
    }

    public Livre() {
        auteur = "inconnu";
        titre = "inconnu";
        prix = 0;
        NbPages = 0;
    }

    public Livre(String auteur, String titre, float prix, int nbPages) {

        if (MAX_LIVRES > NbLivres) {
            this.auteur = auteur;
            this.titre = titre;
            this.prix = prix;
            this.NbPages = nbPages;

            NbLivres++;
            System.out.println("le livre a éte ajouté avec succes.");
        } else {
            //throw new Exception("Vous avez dipassez le nombre maximuin des livres !!!!");
            System.out.println("Vous avez dipassez le nombre maximuin des livres !!!!");
        }
    }

    @Override
    public String toString() {
        return "Auteur : " + getAuteur() + '\n' +
                "Titre : " + getTitre() + '\n' +
                "Prix : " + getPrix() + '\n' +
                "Nombre des pages : " + getNbPages() + '\n';
    }

    public static int getNbLivres() {
        return NbLivres;
    }
}
