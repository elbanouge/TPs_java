package com.company.pkg2;

import com.company.pkg1.Personne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PersonneTestBis {
    public static void main(String[] args) {
        ArrayList<Personne> personnes = new ArrayList<>();

        Personne personne1 = new Personne(1, "fatmi", "amine");
        Personne personne2 = new Personne(2, "lasri", "hicham");
        Personne personne3 = new Personne(3, "wadi", "abdellah");
        Personne personne4 = new Personne(4, "zak", "aabdi");
        Personne personne5 = new Personne(5, "mohmed", "banouge");
        Personne personne6 = new Personne(6, "yadi", "abdellah");

        personnes.add(personne1);
        personnes.add(personne2);
        personnes.add(personne3);
        personnes.add(personne4);
        personnes.add(personne5);
        personnes.add(personne6);

        personnes.forEach(personne -> System.out.println(personne.toString()));

        System.out.println("Taper le crietiere de trier :");
        Scanner scanner = new Scanner(System.in);
        comparePersonnes.TypeComp cr = comparePersonnes.TypeComp.valueOf(scanner.nextLine());
        comparePersonnes comparepersonnes = new comparePersonnes(cr);

        personnes.sort(comparepersonnes);
        System.out.println("*******************************************");
        personnes.forEach(personne -> System.out.println(personne.toString()));

        System.out.println("*******************************************");
        for (Personne personne : personnes) {
            if (personne.getId() == 2) {
                System.out.println(personne.toString());
            }
        }

        System.out.println("*******************************************");
        System.out.println("Rechercher en utilisant le binarySearch : ");
        System.out.print("Taper l'id : ");
        Scanner scanner1 = new Scanner(System.in);
        int id = scanner1.nextInt();
        System.out.print("Taper le nom : ");
        Scanner scanner2 = new Scanner(System.in);
        String nom = scanner2.next();
        System.out.print("Taper le prenom : ");
        Scanner scanner3 = new Scanner(System.in);
        String prenom = scanner3.next();

        int index = Collections.binarySearch(personnes, new Personne(id, nom, prenom), new comparePersonnes(cr));
        if (index < 0)
            System.out.println("Le personne n'est pas trouvee");
        else {
            System.out.println("Info " + index + " : " + personnes.get(index).toString());
        }

        System.out.println("Rechercher le minimum et le maximum d'une list : ");
        Personne min = null;
        Personne max = null;

        for (Personne p : personnes) {
            if (min == null) {
                min = p;
            }

            if (max == null) {
                max = p;
            }

            if (new comparePersonnes(comparePersonnes.TypeComp.NOM).compare(p, min) > 0) {
                min = p;
            }

            if (new comparePersonnes(comparePersonnes.TypeComp.PRENOM).compare(p, max) < 0) {
                max = p;
            }
        }

        System.out.println("*******************************************");
        System.out.println("La personne dont le nom a la valeur minimum de la list est : ");
        System.out.println(min.toString());
        System.out.println("La personne dont le prénom a la valeur maximale de la list est : ");
        System.out.println(max.toString());
    }
}
