package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        FileReader reader = null;
        FileWriter writer = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        ArrayList<Integer> list = new ArrayList<Integer>();

        try {

            File file1 = new File("..\\Exer_03\\test.txt");
            fileInputStream = new FileInputStream(file1);
            reader = new FileReader(file1);
            bufferedReader = new BufferedReader(new FileReader(file1));

            File file2 = new File("testFIOS.txt");
            File file3 = new File("testFRW.txt");
            File file4 = new File("testBRW.txt");

            fileOutputStream = new FileOutputStream(file2);
            writer = new FileWriter(file3);
            bufferedWriter = new BufferedWriter(new FileWriter(file4));

            int n = 0;
            System.out.println("*******************************************");
            long startS = System.currentTimeMillis();
            while ((n = fileInputStream.read()) != -1) {
                fileOutputStream.write(n);
                System.out.print(n + " - " + (char) n);
            }
            System.out.println("\n Copiée términe avec Stream.");
            long finS = System.currentTimeMillis();
            System.out.println("Temps Stream = " + (finS - startS) + " s");
            list.add((int) (finS - startS));

            System.out.println("*******************************************");
            long startR = System.currentTimeMillis();
            while ((n = reader.read()) != -1) {
                writer.write(n);
                System.out.print(n + " - " + (char) n);
            }
            System.out.println("\n Copiée términe avce Reader and Writer.");

            long finR = System.currentTimeMillis();
            System.out.println("Temps Reader and Writer = " + (finR - startR) + " s");
            list.add((int) (finR - startR));

            System.out.println("*******************************************");
            long startB = System.currentTimeMillis();
            while ((n = bufferedReader.read()) != -1) {
                bufferedWriter.write(n);
                System.out.print(n + " - " + (char) n);
            }
            System.out.println("\n Copiée términe avce Buffered.");

            long finB = System.currentTimeMillis();
            System.out.println("Temps Buffered = " + (finB - startB) + " s");
            list.add((int) (finB - startB));

            System.out.println("*******************************************");
            System.out.println("Temps lent = " + Collections.max(list));
            System.out.println("Temps rapide = " + Collections.min(list));

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
            reader.close();
            writer.close();
            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
