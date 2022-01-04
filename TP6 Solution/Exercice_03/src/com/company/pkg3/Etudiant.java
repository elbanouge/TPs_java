package com.company.pkg3;

import com.company.pkg1.Personne;

public class Etudiant extends Personne {

    private long note;

    public Etudiant(long id, String nom, String prenom, long note) {
        super(id, nom, prenom);
        this.note = note;
    }

    public long getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "note=" + note +
                '}';
    }
}
