import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	private double mean;
	private double stddev;
	private double upper;
	private double lower;

	public PercolationStats(int N, int T) {
		if (N <= 0 || T <= 0)
			throw new java.lang.IllegalArgumentException();

		double[] counter = new double[T];
		for (int t = 0; t < T; t++) {

			int count = 0;
			Percolation p = new Percolation(N);

			do {
				int a = StdRandom.uniform(1, N+1);
				int b = StdRandom.uniform(1, N+1);
				if (!p.isOpen(a, b)) {
					p.open(a, b);
					count++;
				}
			} while (!p.percolates());
			counter[t] = ((double)count / (double)(N * N));
		}
		// mean
    	mean = StdStats.mean(counter);

	    // standard deviation
	    stddev = StdStats.stddev(counter);

	    // confidence intervals
	    lower = mean - ((1.96 * stddev) / Math.sqrt(T));
	    upper = mean + ((1.96 * stddev) / Math.sqrt(T));
	}
	public double mean()
	{  return mean;  }

	public double stddev()
	{  return stddev;  }

	public double confidenceLo()
	{  return lower;  }

	public double confidenceHi()
	{  return upper;  }

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int t = Integer.parseInt(args[1]);
		PercolationStats ps = new PercolationStats(n, t);
	    StdOut.println("mean          = " + ps.mean());
	    StdOut.println("stddev        = " + ps.stddev());
	    StdOut.println("95% conf      = " + ps.confidenceLo() + ", " + ps.confidenceHi());
	}
}