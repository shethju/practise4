package com.udemy;

public class MyLinkedList {
	private Node head;
	private Node tail;
	private int length = 0;
	
	public MyLinkedList(int value) {
		Node n = new Node(value);
		head = n;
		tail = n;
		length++;
	}
	
	void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("----------");
	}
	
	// add to end of list
	void append(int value) {
		Node n = new Node(value);
		if (length == 0) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
		length++;
		//print();
	}
	
	// add to start of list
	void prepend(int value) {
		Node n = new Node(value);
		n.next = head;
		head = n;
		length++;
		//print();
	}
	
	// add inbetween list
	void insert(int index, int value) {
		if (index == 0) {
			prepend(value);
			return;
		}
		if (index >= length) {
			append(value);
			return;
		}
		Node temp = traverseToIndex(index - 1);
		Node n = new Node(value);
		length++;
		if (temp == null) {
			head = n;
			tail = n;
			return;
		}
		n.next = temp.next;
		temp.next = n;
		return;
	}
	
	
	void remove(int index) {
		if (index >= length) {
			return;
		}
		Node temp = traverseToIndex(index - 1);
		temp.next = temp.next.next;
		length--;
	}
	
	Node traverseToIndex(int index) {
		if (index < 0) return null;
		Node temp = head;
		if (index > 0 && index < length) {
			for (int i=1; i <= index; i++) {
				temp = temp.next;
			}
		}
		return temp;
	}
	
	void reverse() { // LEArN
		Node previous = null;
		while (head != null) {
			Node next = head.next;
			head.next = previous;
			previous = head;
			head = next;
		}
		head = previous;
	}
}
