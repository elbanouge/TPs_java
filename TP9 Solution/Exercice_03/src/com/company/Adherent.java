package com.company;

public class Adherent {
    private String nom, date, login, metier, genre, sport;
    private byte[] image;

    public Adherent(String nom, String date, String login, String metier, String genre, String sport,
                    byte[] image) {
        this.nom = nom;
        this.date = date;
        this.login = login;
        this.metier = metier;
        this.genre = genre;
        this.sport = sport;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public String getLogin() {
        return login;
    }

    public String getMetier() {
        return metier;
    }

    public String getGenre() {
        return genre;
    }

    public String getSport() {
        return sport;
    }

    public byte[] getImage() {
        return image;
    }
}
