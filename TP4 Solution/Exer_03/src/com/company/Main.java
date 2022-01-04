package com.company;

public class Main {

    public static void main(String[] args) {
        Point point1 = null;
        Point point2 = null;

        try {
            point1 = new Point(4, 3);
            point2 = new Point(-5, 1);

        } catch (PointException e) {
            //System.out.println(e.getMessage());
        } finally {

            if (point2 == null) {
                point2 = new Point();
            } else if (point1 == null) {
                point1 = new Point();
            }

            System.out.println(point1.toString());
            System.out.println(point2.toString());
            System.out.println("Fin du programme.");
        }
    }
}
