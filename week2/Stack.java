import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Node first;  // top of stack
	private int N;

	private class Node {
		// nested class to define nodes
		Item item;
		Node next;
	}

	public boolean isEmpty() {  return first == null;  }
	public int size()		 {  return N;              }

	public void push(Item item) {
		// add item to top of stack
		Node oldFirst = first;
		first = new Node();
		first.item  = item;
		first.next = oldFirst;
		N++;
	}

	public Item pop() {
		// remove item from top of stack
		Item item = first.item;
		first = first.next;
		N--;
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
		Stack<String> s = new Stack<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}