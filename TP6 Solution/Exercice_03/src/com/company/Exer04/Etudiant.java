package com.company.Exer04;

import com.company.pkg1.Personne;

public class Etudiant extends Personne {

    private long note;

    public long getNote() {
        return note;
    }

    public void setNote(long note) {
        this.note = note;
    }

    public Etudiant(long id, String nom, String prenom, long note) {
        super(id, nom, prenom);
        this.note = note;
    }

    @Override
    public String toString() {
        return "Etudiant \n" + super.toString() +
                "\n note=" + note;
    }
}
