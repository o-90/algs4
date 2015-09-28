import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Deque<Item> implements Iterable<Item> {
  private Node<Item> first;
  private Node<Item> last;
  private int N;

  private class Node<Item> {
    Item item;
    Node<Item> next;
    Node<Item> prev;
  }

  public Deque() {
    first = null;
    last = null;
    N = 0;
  }

  public boolean isEmpty()
  {  return N == 0;  }

  public int size()
  {  return N;  }

  public void addFirst(Item item) {
    if (item == null)
      throw new java.lang.NullPointerException();
    Node<Item> newFirst = new Node<Item>();
    newFirst.item = item;
    newFirst.prev = null;
    newFirst.next = first;

    if (isEmpty())
    {  last = newFirst;  }
    else
    {  first.prev = newFirst;  }
    first = newFirst;
    N++;
  }

  public void addLast(Item item) {
    if (item == null)
      throw new java.lang.NullPointerException();
    Node<Item> newLast = new Node<Item>();
    newLast.item = item;
    newLast.prev = last;
    newLast.next = null;

    if (isEmpty())
    {  first = newLast;  }
    else
    {  last.next = newLast;  }
    last = newLast;
    N++;
  }

  public Item removeFirst() {
    // return item;
    if (N == 0)
      throw new java.util.NoSuchElementException();
    Item firstElement = first.item;
    first = first.next;
    N--;

    if (isEmpty())
    {  last = null;  }
    else
    {  first.prev = null;  }
    return firstElement;
  }

  public Item removeLast() {
    // return item;
    if (N == 0)
      throw new java.util.NoSuchElementException();
    Item lastElement = last.item;
    last = last.prev;
    N--;

    if (isEmpty())
    {  first = null;  }
    else
    {  last.next = null;  }
    return lastElement;
  }

  public Iterator<Item> iterator() {
    // iterator()
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node<Item> current = first;
    public boolean hasNext()
    {  return current != null;  }

    public void remove() {
      throw new java.lang.UnsupportedOperationException();
    }
    public Item next() {
      if (!hasNext())
        throw new java.util.NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
  public static void main(String[] args) {
    Deque<Double> deque = new Deque<Double>();
    deque.addFirst(1.0);
    deque.addLast(2.0);
    deque.addFirst(3.0);
    deque.addLast(4.0);
    StdOut.println("size     := " + deque.size());
    StdOut.println("Removed " + deque.removeLast());
    StdOut.println("new size := " + deque.size());
    for (Double d : deque)
      StdOut.println(d);
  }
}
