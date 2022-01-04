package com.company;

public class Adherent {
    private String nom, prenom, tel, login, pass, adrs;
    private String date;
    private double montant;
    private byte sexe = 0;
    private String sport = "";

    public Adherent(String nom, String prenom, String tel, String login, String pass, String adrs, String date, double montant, byte sexe, String sport) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.login = login;
        this.pass = pass;
        this.adrs = adrs;
        this.date = date;
        this.montant = montant;
        this.sexe = sexe;
        this.sport = sport;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAdrs() {
        return adrs;
    }

    public void setAdrs(String adrs) {
        this.adrs = adrs;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public byte getSexe() {
        return sexe;
    }

    public void setSexe(byte sexe) {
        this.sexe = sexe;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
