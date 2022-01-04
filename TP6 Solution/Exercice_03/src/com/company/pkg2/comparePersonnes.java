package com.company.pkg2;

import com.company.pkg1.Personne;

import java.util.Comparator;

public class comparePersonnes implements Comparator<Personne> {

    public enum TypeComp {
        NOM,
        PRENOM;
    }

    private TypeComp critère;

    public TypeComp getCritère()
    {
        return critère;
    }

    public comparePersonnes(TypeComp critère)
    {
        this.critère = critère;
    }


    @Override
    public int compare(Personne p1, Personne p2) {
        int i = -1;

        if (getCritère().equals(TypeComp.NOM)) {
            i = p1.compareTo(p2);
        } else if (getCritère().equals(TypeComp.PRENOM)) {
            i = p1.getPrenom().compareTo(p2.getPrenom());
            if(i == 0){
                i = p1.getNom().compareTo(p2.getNom());
            }
        }

        return i;
    }
}
