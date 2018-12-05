package stack;

class MyStack<T> {
	MyStackNode<T> tos = null;
	
	//public MyStack() {}
	
	boolean empty() {
		return tos == null;
	}
	
	void push(T t) {
		MyStackNode<T> tmp = new MyStackNode<>(t); // Note constructor
		if (tos == null) {
			tos = tmp;
		} else {
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
