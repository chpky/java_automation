package ru.qa.school.core;

public class PointTask {

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(0, -5);

        var ans = p1.distance(p2);
        System.out.println(ans);
    }
}