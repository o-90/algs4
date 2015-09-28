import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int N;
	private Item[] a;

	public RandomizedQueue() {
		a = (Item[]) new Object[1];
		N = 0;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];

		a = temp;
	}
	public void enqueue(Item item) {
		if (item == null)
			throw new java.lang.NullPointerException();
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}
	public Item dequeue() {
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		int idx = StdRandom.uniform(N);  // random index
		Item item = a[idx];        	     // assign random item
		a[idx] = a[N-1];     		     // swap last element
		a[N-1] = null;       		     // make last element null
		N--; 			       		     // decrement N
		if (N > 0 && N == a.length/4)    // resize if necessary
			resize(a.length/2);
		return item;
	}
	public Item sample() {
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		int idx = StdRandom.uniform(N);
		return a[idx];
	}
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	private class ArrayIterator implements Iterator<Item> {
		private int i = N;
		public boolean hasNext() {  return i > 0;   }
		public Item next()    {
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			return a[--i];
		}
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
	} 
	public static void main(String[] args) {
		//StdOut.println("Nothing");
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		rq.enqueue("J");
		rq.enqueue("o");
		rq.enqueue("h");
		rq.enqueue("n");
		StdOut.println("Removed " + rq.dequeue());
		for (String s : rq)
			StdOut.println(s);
	}
}