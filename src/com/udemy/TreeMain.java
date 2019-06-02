package com.udemy;

public class TreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree t = new BinaryTree();
		t.add(10);
		t.add(20);
		t.add(8);
		t.add(5);
		t.add(4);
		t.add(30);
		t.add(25);
		t.printTree();
		System.out.println("---------");
		System.out.println(t.lookup(10));
		System.out.println(t.lookup(8));
		System.out.println(t.lookup(25));
		System.out.println(t.lookup(100));
	}

}
