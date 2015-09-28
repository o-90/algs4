/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *  
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
    }
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
    }
    public Comparator<Point> slopeOrder() {
        /* YOUR CODE HERE */
    }
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}