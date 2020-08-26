package minstackInt;

class MinStack {
	Node tos;

    /*MinStack() {
        tos = null;
    }*/

    //public MinStack() {}
	
	private boolean empty() {
		return tos == null;
	}
	
	void push(int t) {
		Node tmp = new Node(t); // Note constructor
		if (tos == null) {
			tos = tmp;
			tmp.setMinValue(t);
		} else {
			if (t < tos.getMinValue()) {
				tmp.setMinValue(t);
			} else {
				tmp.setMinValue(tos.getMinValue());
			}
			tmp.nextNode = tos;
			tos = tmp;
		}
	}

	void pop() {
		if (empty()) return;
		//int value = tos.getValue();
		tos = tos.nextNode;
	}

	int top() {
		return (empty()) ? -1 : tos.getValue();
	}

	int getMin() {
		return (empty()) ? null : tos.getMinValue();
	}
	
	void print() {
		Node tosCopy = tos;
		System.out.println("Printing values: ");
		while (tosCopy != null) {
			System.out.println(tosCopy.getValue());
			tosCopy = tosCopy.nextNode;
		}
		System.out.println("Done Printing values: ");
	}
	
}
