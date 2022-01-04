package com.company.pkg1;

public class Personne implements Comparable<Personne> {

    private long id;
    private String nom, prenom;

    public Personne(long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }


    @Override
    public int compareTo(Personne o) {
        int i = this.getNom().compareTo(o.getNom());
        if(i==0){
            return this.getPrenom().compareTo(o.getPrenom());
        }

        return i;
    }
}
