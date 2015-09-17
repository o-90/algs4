import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Deque<Item> implements Iterable<Item> {

  private Node first;
  private Node last;
  private int  N;

  private class Node {
    Item item;
    Node next;
    Node prev;
	}

  public Deque() {
  }

  public boolean isEmpty() {
    return true;
  }

  public int size() {
    return 1;
  }

  public void addFist(Item item) {
  }

  public void addLast(Item item) {
  }

  public Item removeFirst() {
    //return item;
  }

  public Item removeLast() {
    //return item;
  }

  public Iterator<Item> iterator() {
  }

  public static void main(String[] args) {
  }
}
