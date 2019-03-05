public class LinkedList2018Fv3<T> {
	private static class Node<T> { // LinkedList.Node
		T v;
		Node next;
		public Node(T v, Node n) { this.v = v; next = n; }
	}
	private Node head;
	public LinkedList2018Fv3() {
		head = null;
	}

	public void addEnd(T v) {
		if (head == null) {
			addStart(v);
			return;
		}
		// invariant: head is not null, list has at least 1 element
		Node p;
		for (p = head; p.next != null; p= p.next)
			;
		p.next = new Node(v, null);
	}
	public void addStart(T v) {
		head = new Node(v, head);
	}
	public void removeEnd() {
		if (head == null)
			return;
		if (head.next == null) {
			head = null;
			return;
		}
		// invariant: there are at least 2 elements
		Node p, q;
		for (p = head, q = p.next; q.next != null; p = q, q = q.next)
			;
		p.next = null;
	}
	public void removeStart() {
		head = head.next;
	}
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (Node p = head; p != null; p = p.next)
			b.append(p.v).append(' ');
		return b.toString();
	}
	public static void main(String[]args) {
		LinkedList2018Fv3<Egg> a = new LinkedList2018Fv3<>();
		for (int i = 10; i > 0; i--)
			a.addStart(new Egg());
		System.out.println(a);
	}
}

class Egg {
}
