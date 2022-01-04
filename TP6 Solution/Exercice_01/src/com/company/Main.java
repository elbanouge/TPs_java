package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Meknes");
        list.add("Tiznit");
        list.add("Agadir");
        list.add("Rabat");

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("*****************");
        Collections.sort(list);

        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("*****************");

        ListIterator iterator = list.listIterator();
        iterator.next();
        iterator.next();
        iterator.set("Safi");

        for (String s : list) {
            System.out.println(s);
        }

        list.remove(1);
        System.out.println("*****************");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
