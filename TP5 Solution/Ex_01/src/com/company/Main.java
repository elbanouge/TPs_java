package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static String ScannerInputSring(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static int ScannerInputInt(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    public static double ScannerInputDouble(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        return input;
    }

    public static void AjouterEmp(Personnel personnel, String type, String cfEmp) {
        String nom = ScannerInputSring("- Taper le nom de l'employes.");
        String prenom = ScannerInputSring("- Taper le prenom de l'employes.");
        int age = ScannerInputInt("- Taper l'age de l'employes.");
        String date = ScannerInputSring("- Taper la date de mise en srevice de l'employes.");
        String service = ScannerInputSring("- Taper le nom de servie de l'employes.");
        double cf = ScannerInputDouble("- Taper le " + cfEmp + " de l'employes.");

        if (type.equals("Representant")) {
            Employe employe = new Representant(nom, prenom, age, date, service, cf);
            personnel.ajouterEmploye(employe);
        } else if (type.equals("Vendeur")) {
            Employe employe = new Vendeur(nom, prenom, age, date, service, cf);
            personnel.ajouterEmploye(employe);
        } else if (type.equals("Technicien")) {
            Employe employe = new Technicien(nom, prenom, age, date, service, cf);
            personnel.ajouterEmploye(employe);
        } else if (type.equals("Manutentionnaire")) {
            Employe employe = new Manutentionnaire(nom, prenom, age, date, service, cf);
            personnel.ajouterEmploye(employe);
        } else if (type.equals("TechnicienR")) {
            Employe employe = new TechnicienARisque(nom, prenom, age, date, service, cf);
            personnel.ajouterEmploye(employe);
        } else if (type.equals("ManutentionnaireR")) {
            Employe employe = new ManutentionnaireARisque(nom, prenom, age, date, service, cf);
            personnel.ajouterEmploye(employe);
        }
    }

    public static void main(String[] args) {
        Personnel personnel = null;
        int choix = 0;
        int nb = 0;

        try {
            do {
                System.out.println(" ________________________________________________________________________");
                System.out.println("|                           Bonjour Abdellah                             |");
                System.out.println("|________________________________________________________________________|");
                System.out.println("|                                  MENU                                  |");
                System.out.println("|                   Gérer les salaires des employés                      |");
                System.out.println("|________________________________________________________________________|");
                System.out.println(" ________________________________________________________________________");
                System.out.println("| 1)- Taper le nombre d’employés à ajouter. \t\t\t\t\t\t\t |");
                System.out.println("|________________________________________________________________________|");
                System.out.println("| 2)- ajouter un employe \t\t\t\t\t\t\t\t\t\t\t\t |");
                System.out.println("|________________________________________________________________________|");
                System.out.println("| 3)- afficher les informations et le salaires de tout les employes \t |");
                System.out.println("|________________________________________________________________________|");
                System.out.println("| 4)- afficher le salaire moyenne de tout les employes. \t\t\t\t |");
                System.out.println("|________________________________________________________________________|");
                System.out.println("| 5)- Quiter. \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t |");
                System.out.println("|________________________________________________________________________|");
                choix = ScannerInputInt("************************** Taper votre choix ****************************");

                switch (choix) {
                    case 1:
                        nb = ScannerInputInt("- Taper nombres des employes.");
                        personnel = new Personnel(nb);
                        break;
                    case 2:
                        if (nb != 0) {
                            System.out.println("| \t 2-1)- ajouter un employe de type Représentant. \t\t\t\t\t |");
                            System.out.println("| \t 2-2)- ajouter un employe de type Vendeur. \t\t\t\t\t\t\t |");
                            System.out.println("| \t 2-3)- ajouter un employe de type Technicien. \t\t\t\t\t\t |");
                            System.out.println("| \t 2-4)- ajouter un employe de type Manutentionnaire. \t\t\t\t |");
                            System.out.println("|________________________________________________________________________|");
                            choix = ScannerInputInt("************************** Taper votre choix ****************************");
                            switch (choix) {
                                case 1:
                                    AjouterEmp(personnel, "Representant", "chiffre d'affaire");
                                    break;
                                case 2:
                                    AjouterEmp(personnel, "Vendeur", "chiffre d'affaire");
                                    break;
                                case 3:
                                    System.out.println("| \t\t 2-3-1)- ajouter un employe de type Technicien normal. \t\t\t |");
                                    System.out.println("| \t\t 2-3-2)- ajouter un employe de type Technicien a risque. \t\t |");
                                    choix = ScannerInputInt("************************** Taper votre choix ****************************");
                                    if (choix == 1) {
                                        AjouterEmp(personnel, "Technicien", "nombre d'unites");
                                    } else {
                                        AjouterEmp(personnel, "TechnicienR", "nombre d'unites");
                                    }
                                    break;
                                case 4:
                                    System.out.println("| \t\t 2-4-1)- ajouter un employe de type Manutentionnaire normal. \t |");
                                    System.out.println("| \t\t 2-4-2)- ajouter un employe de type Manutentionnaire a risque. \t |");
                                    choix = ScannerInputInt("************************** Taper votre choix ****************************");
                                    if (choix == 1) {
                                        AjouterEmp(personnel, "Manutentionnaire", "nombre de heures");
                                    } else {
                                        AjouterEmp(personnel, "ManutentionnaireR", "nombre de heures");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 3:
                        if (nb != 0) {
                            System.out.println("- Les salires des employes et son informations sont : ");
                            personnel.afficherSalaires();
                        }
                        break;
                    case 4:
                        if (nb != 0) {
                            System.out.println("- Le salire moyenne des employes sont : " + personnel.salaireMoyen());
                        }
                        break;
                    default:
                        break;
                }
            } while (choix != 5);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
