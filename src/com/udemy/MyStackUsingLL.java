package com.udemy;

public class MyStackUsingLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack st = new MyStack(1);
		st.push(2);
		System.out.println(st.peek());
		st.push(0);
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.peek());
		
	}

}
