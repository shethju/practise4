package stack;

public class MyStackNode<T>{
	private T t;
	MyStackNode<T> nextNode = null;
	MyStackNode(T tValue) { // new Node<T>(t);
		t = tValue;
	}
	T getValue() { return t; }
	
}
