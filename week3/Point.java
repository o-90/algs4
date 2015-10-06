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
import edu.princeton.cs.algs4.StdOut;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y)
    {  this.x = x;  this.y = y;  }

    public void draw()
    {  StdDraw.point(x, y);  }

    public void drawTo(Point that)
	{  StdDraw.line(this.x, this.y, that.x, that.y);  }

    public double slopeTo(Point that) {
    	double dx = that.x - this.x;
    	double dy = that.y - this.y;

    	if      (dx == 0 && dy == 0) {  return Double.NEGATIVE_INFINITY;  }
    	else if (dx == 0)            {  return Double.POSITIVE_INFINITY;  }
    	else if (dy == 0)            {  return 0.0;                       }

    	return dy / dx;
    }

    public int compareTo(Point that) {
    	if      (that.y > this.y) {  return -1;  }
    	else if (that.y < this.y) {  return  1;  }
    	else if (that.x > this.x) {  return -1;  }
    	else if (that.x < this.x) {  return  1;  }
        else                      {  return  0;  }
    }

    public Comparator<Point> slopeOrder() {
        return new Comparator<Point>() {
            public int compare(Point n, Point m) {
                double slopeN = slopeTo(n);
                double slopeM = slopeTo(m);
                return Double.compare(slopeN, slopeM);
            }
        };
    }

    public String toString()
    {  return "(" + x + ", " + y + ")";  }

    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,5);
        StdOut.println("The slope of p1 and p2 is " + p1.slopeTo(p2));

        Point p3 = new Point(3,7);
        Point p4 = new Point(1,8);
        StdOut.println("Is point p3 < point p4? " + p3.compareTo(p4));
    }
}