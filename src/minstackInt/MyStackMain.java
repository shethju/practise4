package minstackInt;

public class MyStackMain {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-1);
		System.out.println(minStack.getMin());  // --> Returns -3.
		System.out.println(minStack.top());     // --> Returns 0.
		minStack.pop();
		System.out.println(minStack.getMin());  // --> Returns -2.
	}

}
