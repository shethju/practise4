package com.udemy;

import java.util.LinkedList;
import java.util.List;

public class MyStack {
	private List<Integer> list = new LinkedList<Integer>();
	public MyStack(int value) {
		list.add(value);
	}
	
	int peek() {
		if (list.size() == 0) return -11;
		return list.get(list.size()-1);
	}
	
	void push(int value) {
		list.add(value);
	}
	
	void pop() {
		int value = peek();
		list.remove(list.size()-1);
	}
}
