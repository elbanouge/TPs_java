package com.company.Exer04;

import java.util.HashMap;
import java.util.Scanner;

public class EtudiantTest {
    public static double getMoyenne(HashMap<Long, Etudiant> Map) {
        double Moy = 0;

        for (Etudiant etudiant : Map.values()) {
            Moy += etudiant.getNote();
        }

        return Moy / Map.size();
    }

    public static void affiche(HashMap<Long, Etudiant> Map) {
        for (Etudiant etudiant : Map.values()) {
            System.out.println(etudiant.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        HashMap<Long, Etudiant> map = new HashMap<Long, Etudiant>();

        System.out.println("Taper numbres des etudiants : ");
        scanner = new Scanner(System.in);
        int num = scanner.nextInt();

            int i = 0;
            do {
                System.out.println("L'etudiant " + (i+1) + " :");
                System.out.println("Taper l'id de l'etudiant : ");
                scanner = new Scanner(System.in);
                Long id = scanner.nextLong();
    
                System.out.println("Taper le nom de l'etudiant : ");
                scanner = new Scanner(System.in);
                String nom = scanner.nextLine();
    
                System.out.println("Taper le prenom de l'etudiant : ");
                scanner = new Scanner(System.in);
                String prenom = scanner.nextLine();
    
                System.out.println("Taper la note de l'etudiant : ");
                scanner = new Scanner(System.in);
                int note = scanner.nextInt();
    
                Etudiant etudiant = new Etudiant(id, nom, prenom, note);
                map.put(id, etudiant);
    
                i++;
            } while (num != i);
    
            System.out.println("****************************************************************");
            affiche(map);
    
            System.out.println("****************************************************************");
            System.out.println("La moyenne de tous les étudiants est " + getMoyenne(map));
    
            System.out.println("****************************************************************");
            System.out.println("taper l'id de l'étudiant qui vous voulez supprime :");
            scanner = new Scanner(System.in);
            Long id = scanner.nextLong();
            map.remove(id);
            affiche(map);
    
            System.out.println("****************************************************************");
            System.out.println("La moyenne de tous les étudiants est " + getMoyenne(map));
    
        }
    }
