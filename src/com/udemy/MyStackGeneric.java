package com.udemy;

import java.util.LinkedList;
import java.util.List;

public class MyStackGeneric<T> {
	private List<T> list = new LinkedList<>();
	public MyStackGeneric(T value) {
		list.add(value);
	}
	
	T peek() {
		if (list.size() == 0) return null;
		return list.get(list.size()-1);
	}
	
	void push(T value) {
		list.add(value);
	}
	
	void pop() {
		T value = peek();
		list.remove(list.size()-1);
	}
}
