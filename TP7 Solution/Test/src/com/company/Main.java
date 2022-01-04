package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        Personne personne = new Personne("Abdellah", "Elbanouge", 26);

        File file = new File("FileT.txt");

        try {

            ObjectOutputStream outputStream = new ObjectOutputStream(new  BufferedOutputStream(new FileOutputStream(file)));

            outputStream.writeObject(personne);
            outputStream.close();

            //System.out.println(personne);

            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            Personne p = (Personne) inputStream.readObject();
            inputStream.close();

            System.out.println(p.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
