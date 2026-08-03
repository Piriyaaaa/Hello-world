package Intermediate;

public class CircularLinkedList {
	static class Node{
		int data;
		Node next;
		Node (int data) {this.data =data;}
		
	}
	static class CircularLinkedListImpl {
		private Node head = null;
		private Node tail = null;
		
		public void add(int value) {
			Node newNode = new Node(value);
			  if(head == null) {
				  head = newNode;
				  tail = newNode;
			  }
		}
		public void printList() {
			if (head == null) {
				System.out.println("List is empty");
				return;
			}
			Node curr =head;
			do {
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
			while (curr != head);
		}
	}
	public static void main(String[] args) {
		CircularLinkedListImpl cll = new CircularLinkedListImpl();
		
		cll.add(10);
		cll.add(20);
		cll.add(30);
		cll.add(40);
		
		cll.printList();
	}

}









