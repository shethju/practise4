package minstackInt;

class Node{
	private int t;
	private int minValue;
	int getMinValue() {
		return minValue;
	}
	void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	Node nextNode = null;
	Node(int tValue) { // new Node<T>(t);
		t = tValue;
	}
	int getValue() { return t; }
	

}
