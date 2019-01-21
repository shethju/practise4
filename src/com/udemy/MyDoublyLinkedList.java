package com.udemy;

public class MyDoublyLinkedList {
	private DoublyNode head;
	private DoublyNode tail;
	private int length = 0;
	
	public MyDoublyLinkedList(int value) {
		DoublyNode n = new DoublyNode(value);
		head = n;
		tail = n;
		length++;
	}
	
	void print() {
		DoublyNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("----------");
	}
	
	// add to end of list
	void append(int value) {
		DoublyNode n = new DoublyNode(value);
		if (length == 0) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			n.previous = tail;
			tail = n;
		}
		length++;
		
	}
	
	// add to start of list
	void prepend(int value) {
		DoublyNode n = new DoublyNode(value);
		n.next = head;
		head = n;
		length++;
	}
	
	// add inbetween list
	void insert(int index, int value) {
		DoublyNode currentNode = traverseToIndex(index - 1);
		DoublyNode n = new DoublyNode(value);
		length++;
		if (currentNode == null) {
			head = n;
			tail = n;
			return;
		}
		DoublyNode nextNode = currentNode.next;
		n.next = nextNode;
		n.previous = currentNode;
		nextNode.previous = n;
		currentNode.next = n;
		return;
	}
	
	
	void remove(int index) {
		if (index >= length) {
			return;
		}
		DoublyNode currentNode = traverseToIndex(index - 1);
		DoublyNode nextNode = currentNode.next.next;
		currentNode.next = nextNode;
		nextNode.previous = currentNode;
		length--;
	}
	
	DoublyNode traverseToIndex(int index) {
		if (index > 0 && index < length) {
			DoublyNode temp = head;
			for (int i=1; i <= index; i++) {
				temp = temp.next;
			}
			return temp;
		}
		return head;
	}
	
	
}
