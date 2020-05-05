package linkedlist;

public class utils {
	
	public void printList(Node node) {
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
}

class Node {
	int data; 
	Node next;
	Node (int d) {
		data = d;
		next = null;
	}
}

