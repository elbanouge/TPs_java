package com.company;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector vector = new Vector(3,2);

        System.out.println(vector.size());
        System.out.println(vector.capacity());
        System.out.println("****************");

        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4 );

        System.out.println(vector.capacity());
        vector.addElement(new Double(5.45));
        System.out.println(vector.capacity());

        System.out.println("****************");
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
        System.out.println("****************");
        if (vector.contains(3)) {
            System.out.println("Element rechreche touve");
        }
        System.out.println("Nombre elemnent = "+ vector.capacity());
        vector.forEach(o -> System.out.println(o));

        System.out.println("****************");
        System.out.println("Les elements de vector sont :");
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement()+" ");
        }
    }
}
