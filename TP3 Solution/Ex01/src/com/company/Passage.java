package com.company;

public class Passage {
    int n;
    void methode1() {
        n += 10;
       // System.out.println(n);
    }

    void methode2() {
        int n = 2;
        System.out.println(n);
        methode1();
        System.out.println("n=" + n);
    }

    public static String s = "Salam";
    public static void concat1(String s2) {
        s += s2;
    }

    public static void concat2(StringBuffer s, StringBuffer s2) {
        s.append(s2);
    }

    void methode3() {
        concat1( " tout le monde");
        System.out.println(s);
    }

    void methode4() {
        StringBuffer s1 = new StringBuffer("Salam");
        StringBuffer s2 = new StringBuffer(" tout le monde");
        concat2(s1, s2);
        System.out.println(s1);
    }
}