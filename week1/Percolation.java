import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private boolean[][] grid;

  public Percolation(int N) {
    grid = new boolean[N][N];
    for (int i=0; i<N; i++)
      for (int j=0; j<N; j++)
        grid[i][j] = false;
  }

  //public void open(int i, int j)          // open site if its not open
  //public boolean isOpen(int i, int j)     // is site open?
  //public boolean isFull(int i, int j)     // is site full?
  //public boolean percolates()             // does system percolate?
  //                                        //
  //public static void main(String[] args)  // test client

  public void open(int i, int j)
  {  grid[i][j]=true;  }

  public boolean isOpen(int i, int j) {
    if (grid[i][j] != false)
      return true;
    return false;
  }

  //public boolean isFull(int i, int j) {
  //}

  //public boolean percolates() {
  //}
}
