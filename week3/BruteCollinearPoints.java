import java.util.Comparator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

public class BruteCollinearPoints {
	public BruteCollinearPoints(Point[] points)
	public int numberOfSegments()
	public LineSegment[] segments()
	public static void main(String[] args) {
		// read the N points from a file
		In in = new In(args[0]);
		int N = in.readInt();
		Point[] points = new Points[N];
		for (int i = 0; i < N; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}

		// draw the points
		StdDraw.show(0);
		StdDraw.setXScale(0, 32768);
		StdDraw.setYScale(0, 32768);
		for (Point p : points) {
			p.draw();
		}
		
		StdDraw.show();
		BruteCollinearPoints collinear = new BruteCollinearPoints(points);
		for (LineSegment segment : collinear.segments()) {
			StdOut.println(segment);
			segment.draw();
		}
	}
}