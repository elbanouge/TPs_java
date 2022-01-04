package com.company;

public class Livre {

    private String auteur, titre;
    private float prix;
    private int nbpages;
    private static int NbLivres = 0;
    private static final int MAX_LIVRES = 5;

    public Livre(String Auteur, String Titre, float Prix, int Nb){
        if(MAX_LIVRES < NbLivres){
            System.out.println("Le nombre maximal de livres qu’on peut créer va être dépassé");
        }else {
            NbLivres++;

            auteur = Auteur;
            titre = Titre;
            prix = Prix;
            nbpages = Nb;
            System.out.println("Livre créé avec succès");
        }
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public float getPrix() {
        return prix;
    }

    public int getNbpages() {
        return nbpages;
    }

    @Override
    public String toString() {
        String s = "L'auteur du livre Programmer en " + getTitre() +
                " est " + getAuteur() +
                ". Ce livre contient " + getNbpages() +
                " pages et ";
        return s;
    }

    public void categoriePrix(Livre livre){
        if(livre.getPrix() <= 25){
            System.out.println("il n'est pas cher.");
        }
        else if(livre.getPrix() <= 60){
            System.out.println("il a un prix moyen.");
        }
        else {
            System.out.println("il est cher.");
        }
    }

    public static int getNbLivres(){
        return NbLivres;
    }
}
