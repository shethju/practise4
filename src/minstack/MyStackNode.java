package minstack;

public class MyStackNode<T extends Comparable<T>>{
	private T t;
	private T minValue;
	public T getMinValue() {
		return minValue;
	}
	public void setMinValue(T minValue) {
		this.minValue = minValue;
	}
	public MyStackNode<T> nextNode = null;
	public MyStackNode(T tValue) { // new Node<T>(t);
		t = tValue;
	}
	public T getValue() { return t; }
	
	public int compareTo(MyStackNode<T> tos) {
		// TODO Auto-generated method stub
		return t.compareTo(tos.getValue());
	}
}
