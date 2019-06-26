package list_iterator;

import java.io.LineNumberInputStream;
import java.util.Iterator;

class LinkedList<E> {

	Node head = null;
	Node tail = null;

	class Node {
		E element;
		Node next;

		Node(E element) {
			this.element = element;
			this.next = null;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	public void add(E element) {
		Node node = new Node(element);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = tail.getNext();
		}
	}

	public void display() {
		Node temp = head;

		while (temp != null) {
			System.out.println(temp.getElement());
			temp = temp.getNext();
		}
	}

	public Iterator iterator() {
		class X implements Iterator<E> {
			Node temp = head;

			@Override
			public boolean hasNext() {
				if (temp != null)
					return true;
				else
					return false;
				
			}

			@Override
			public E next() {
				Node node = temp;
				temp = temp.getNext();
				return node.getElement();
			}
		}
		
		
		X x = new X();

		return x;

	}

}

public class App {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(5);
		linkedList.add(10);
		linkedList.display();
System.out.println("-----------------------------------------------------------------------------");
		Iterator it = linkedList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}
}
