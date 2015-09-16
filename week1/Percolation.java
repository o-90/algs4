import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private int N=0;
  private boolean[] grid = null;
  private WeightedQuickUnionUF uf = null;

  public Percolation(int N) {

    // empty grid
    grid = new boolean[N * N + 2];
    for (int i=0; i<N; i++)
      for (int j=0; j<N; j++)
        grid[i * N + j] = false;

    // make dummy connections for top and bottom
    grid[N * N]     = true;
    grid[N * N + 1] = true;

    // create quick union network
    this.N = N;
    uf = new WeightedQuickUnionUF(N * N + 2);
  }

  public void open(int i, int j) {
    // create open sites

    if (i < 1 || j < 1 || i > N || j > N)
      throw new java.lang.IndexOutOfBoundsException();
    int a = i - 1;
    int b = j - 1;

    if (!grid[a * N + b]) {
      grid[a * N + b] = true;

      // up
      if((a-1) >= 0 && b >= 0 && (a-1) < N && b < N && grid[(a-1)*N+b])
        uf.union(a * N + b, (a - 1) * N + b);
      // down
      if((a+1) >= 0 && b >= 0 && (a+1) < N && b < N && grid[(a+1)*N+b])
        uf.union(a * N + b, (a + 1) * N + b);
      // left
      if(a >= 0 && (b-1) >= 0 && a < N && (b-1) < N && grid[a*N+(b-1)])
        uf.union(a * N + b, a * N + (b - 1));
      // right
      if(a >= 0 && (b+1) >= 0 && a < N && (b+1) < N && grid[a*N+(b+1)])
        uf.union(a * N + b, a * N + (b + 1));

      if (i == 1)
        uf.union(a * N + b, N * N);
      if (i == N)
        uf.union(a * N + b, N * N + 1);
    }
  }

  public boolean isOpen(int i, int j) {
    // is i,j open?
    int a = i - 1;
    int b = j - 1;
    return grid[a * N + b];
  }

  public boolean isFull(int i, int j) {
    // is i,j connected to top node?
    int a = i - 1;
    int b = j - 1;
    return uf.connected(N * N + 1, a * N + b);
  }

  public boolean percolates()
  {  return uf.connected(N * N, N * N + 1);  }

  // test client
  public static void main(String[] args) {
    double r = 0.6;
    int n = 20;

    Percolation p = new Percolation(n);
    for (int i=0; i<n; i++)
      for (int j=0; j<n; j++)
        if (StdRandom.bernoulli(r))
          p.open(i+1, j+1);

    StdOut.println("Does the system percolate?\n" + p.percolates());
  }
}
