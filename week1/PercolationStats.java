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

    double[] count = new double[T];

    for (int t=0; t<T; t++) {

      int counter = 0;
      Percolation p = new Percolation(N);

      while(!p.percolates()) {
        int a = StdRandom.uniform(1,N);
        int b = StdRandom.uniform(1,N);
        if (!p.isOpen(a, b)) {
          counter++;
          p.open(a, b);
        }
      }
      count[t] = counter;
    }
    // mean
    //for (int t=0; t<T; t++) mean += count[t];
    //mean /= T;
    mean = StdStats.mean(count);

    // standard deviation
    //for (int t=0; t<T; t++) stddev += (count[t]-mean)*(count[t] - mean);
    //stddev /= (T-1);
    //stddev = Math.sqrt(stddev);
    stddev = StdStats.stddev(count);

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
    PercolationStats ps = new PercolationStats(20, 10);
    StdOut.println("mean\t\t\t = " + ps.mean());
    StdOut.println("stddev\t\t = " + ps.stddev());
    StdOut.println("95% conf\t = " + ps.confidenceLo() + ", " + ps.confidenceHi());
  }
}
