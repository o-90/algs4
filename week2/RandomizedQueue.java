import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterator<Item> {
  private Node<Item> first;
  private Node<Item> last;
  private N;

  private class Node<Item> {
  	Item item;
  	Node next;
  }

  public RandomizedQueue<Item>() {
  	first = null;
  	last = null;
  	N = 0;
  }

  public boolean isEmpty()
  {  return N == 0}

  public int size()
  {  return N;  }

  public void enqueue(Item item) {

  }

  public Item dequeue() {

  }

  public Item sample() {

  }

  public Iterator<Item> iterator()
  {  return new ListIterator();  }

  private class ListIterator implements Iterator<Item> {
  	private Node<Item> current = first;
  	public boolean hasNext();
  	{  return current = null;  }
  	public void remove()
    {  /* put exception handling here */  }
    public Item next() {
    	Item item = current.item;
    	current = current.next;
    	return item;
    }
  }
  public static void main(String[] args) {
  }
}