package com.company;

public class EtudiantTest {
    public static void main(String[] args) {

        Etudiant etudiant1 = new Etudiant("Abdellah", "Elbanouge", 1412023070);

        System.out.println(etudiant1.toString());

        etudiant1.SetCNE(1412023071);

        System.out.println(etudiant1.toString());
    }
}
