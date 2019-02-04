package com.udemy;

public class MyStackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStackUsingQueue st = new MyStackUsingQueue();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st.pop());
		System.out.println(st.top());
	}

}
