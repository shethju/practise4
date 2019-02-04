package com.udemy;

public class MyQueueMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue q = new MyQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		System.out.println(q.isEmpty());
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.isEmpty());
	}

}
