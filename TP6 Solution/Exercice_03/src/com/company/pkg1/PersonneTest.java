package com.company.pkg1;

import com.company.pkg1.Personne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PersonneTest {

    public static void main(String[] args) {
        ArrayList<Personne> personneArrayList = new ArrayList<>();

        Personne personne1 = new Personne(1, "mohmed", "banouge");
        Personne personne2 = new Personne(2, "hicham", "lasri");
        Personne personne3 = new Personne(3, "abde", "kadi");
        Personne personne4 = new Personne(4, "abde", "alalli");

        personneArrayList.add(personne1);
        personneArrayList.add(personne2);
        personneArrayList.add(personne3);
        personneArrayList.add(personne4);

        Iterator<Personne> iterator = personneArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Info : " + iterator.next().toString());
        }
        System.out.println("*******************************************");
        //Trier la liste
        Collections.sort(personneArrayList);

        for (Personne personne : personneArrayList) {
            System.out.println(personne.toString());
        }


    }
}
