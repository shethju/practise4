package com.udemy;

import java.util.LinkedList;
import java.util.List;

public class MyQueue {
	List<Node> list = new LinkedList<>();
	int length = 0;
	
	int peek() {
		if (length <= 0) return -1;
		int value = list.get(0).data;
		return value;
	}
	
	void enqueue(int value){
		list.add(new Node(value));
		length++;
	}
	
	int dequeue(){
		int value = peek();
		list.remove(0);
		length--;
		return value;
	}
	
	boolean isEmpty() {
		return length <= 0 ? true : false;
	}
}
