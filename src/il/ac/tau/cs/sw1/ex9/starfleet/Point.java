package il.ac.tau.cs.sw1.ex9.starfleet;

import java.io.EOFException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Point{
    private int x,y;
    private Random rand = new Random();
    public Point(int x, int y){ this.x = x; this.y = y; }
    @Override
    public boolean equals(Object o){
        Point other = (Point)o;
        return this.x+this.y == other.x+other.y;
    }
    @Override
    public int hashCode(){ return rand.nextInt(3); } //random in [0,2]
    public static void main(String[] args){
        Point p1 = new Point(1,5);
        Point p2 = new Point(2,4);
        Point p3 = new Point(3,6);
        Set<Point> set = new HashSet<>();
        set.add(p1);
        System.out.println(set.contains(p1)); //#
        System.out.println(set.contains(p2)); //$
        System.out.println(set.contains(p3)); //*
    }
}