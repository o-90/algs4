import java.util.Iterator;

public class Queue <Item> implements Iterable<Item> {
	private Node first; // link to least revently added node
	private Node last;  // link to most revently added node
	private int N;      // number of items on the queue

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {  return first == null;  }
	public int size() 		 {  return N;     		   }

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else 		   oldLast.next = last;
		N++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) last = null;
		return item;
	}

	public Iterator<Item> iterator()
	{  return new ListIterator();  }

	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext()
		{  return current != null;  }
		public void remove() {  }
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		// create a stack and push/pop strings as directed on StdIn
		Queue<String> q = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				q.enqueue(item);
			else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}
}