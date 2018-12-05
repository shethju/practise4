package minstack;

class MyStack<T extends Comparable<T>> {
	MyStackNode<T> tos = null;
	
	//public MyStack() {}
	
	boolean empty() {
		return tos == null;
	}
	
	void push(T t) {
		MyStackNode<T> tmp = new MyStackNode<T>(t); // Note constructor
		if (tos == null) {
			tos = tmp;
			tmp.setMinValue(t);
		} else {
			if (tmp.compareTo(tos) < 0) {
				tmp.setMinValue(t);
			} else {
				tmp.setMinValue(tos.getMinValue());
			}
			tmp.nextNode = tos;
			tos = tmp;
		}
	}
	
	T pop() {
		if (empty()) return null;
		T value = tos.getValue();
		tos = tos.nextNode;
		return value;
	}

	T peek() {
		return (empty()) ? null : tos.getValue();
	}
	
	T getMinValue() {
		return (empty()) ? null : tos.getMinValue();
	}
	
	void print() {
		MyStackNode<T> tosCopy = tos;
		System.out.println("Printing values: ");
		while (tosCopy != null) {
			System.out.println(tosCopy.getValue());
			tosCopy = tosCopy.nextNode;
		}
		System.out.println("Done Printing values: ");
	}
	
}
