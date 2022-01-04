package com.company;

import java.io.File;

public class Fichier {
    public static void main(String[] args) {
        File file = new File("..\\Exer_01\\test.txt");

        System.out.println("********************************************");
        System.out.println("Absolute File = " + file.getAbsoluteFile());
        System.out.println("Name = " + file.getName());

        System.out.println("********************************************");
        if (file.exists()) {
            System.out.println("Ce fichier est existe");
        } else {
            System.out.println("Ce fichier n'est pas existe !!!");
        }

        System.out.println("********************************************");
        if (file.isDirectory()) {
            System.out.println("Ce chemin est un répertoire");
        } else if (file.isFile()) {
            System.out.println("Ce chemin est un fichier");
        }

        System.out.println("********************************************");
        System.out.println("file is Read = " + file.canRead());
        System.out.println("file is Write = " + file.canWrite());
        System.out.println("file is Execute = " + file.canExecute());

        System.out.println("********************************************");
        File fileD = new File("..\\Exer_01\\TestRep");

        if (fileD.mkdir()) {
            System.out.println("Ce répertoire a ete crée");
        } else {
            System.out.println("Ce répertoire n'est pas crée !!!");
        }

        System.out.println("********************************************");
        System.out.println("Absolute File = " + fileD.getAbsoluteFile());
        System.out.println("Name = " + fileD.getName());

        System.out.println("********************************************");
        if (fileD.exists()) {
            System.out.println("Ce fichier est existe");
        } else {
            System.out.println("Ce fichier n'est pas existe !!!");
        }

        System.out.println("********************************************");
        if (fileD.isDirectory()) {
            System.out.println("Ce chemin est un répertoire");
        } else if (fileD.isFile()) {
            System.out.println("Ce chemin est un fichier");
        }

        System.out.println("********************************************");
        System.out.println("file is Read = " + fileD.canRead());
        System.out.println("file is Write = " + fileD.canWrite());
        System.out.println("file is Execute = " + fileD.canExecute());

        System.out.println("********************************************");
        for (File file1 : File.listRoots()) {
            try {
                for (File file2 : file1.listFiles()) {
                    if (file2.isDirectory()) {
                        System.out.println(file2.getName() + "/");
                    } else {
                        System.out.println(file2.getName());
                    }
                }
            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("********************************************");
        /*if (fileD.exists()) {
            fileD.delete();
            System.out.printf("suprime avec sucees.");
        }*/
    }
}
