package com.company;

public class Main {

    public static void main(String[] args) {

        IntException exception = new IntException();

        int r = exception.SaisieInt();
        System.out.println(r);

    }
}
