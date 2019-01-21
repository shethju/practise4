package com.udemy;

public class MyDoublyLinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList m = new MyLinkedList(15);
		m.print();
		m.append(11);
		m.print();
		m.remove(0);
		m.print();
		m.insert(0, 10);
		m.print();
		m.prepend(20);
		m.print();
	}

}
