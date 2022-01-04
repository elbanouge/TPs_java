package com.company;

public class Point {
    int x, y;

    public Point() {
        x = -10000;
        y = -10000;
    }

    public Point(int x, int y) throws PointException {
        if (x < 0 || y < 0) {
            throw new PointException();
        }
        else {
            this.x = x;
            this.y = y;
            System.out.println("Le point est créé avec succès.");
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
