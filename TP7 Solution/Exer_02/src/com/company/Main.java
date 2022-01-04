package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            File file1 = new File("..\\Exer_02\\test.txt");
            fileInputStream = new FileInputStream(file1);

            File file2 = new File("testCopie.txt");
            fileOutputStream = new  FileOutputStream(file2);

            int n = 0;

            while ((n = fileInputStream.read()) != -1){
                fileOutputStream.write(n);
                System.out.println( n + " - " + (char) n);
            }

            System.out.println("Copiée términe.");


        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        } catch (IOException exception){
            exception.printStackTrace();
        }
        finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
