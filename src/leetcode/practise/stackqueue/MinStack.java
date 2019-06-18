package leetcode.practise.stackqueue;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MS {
	MSNode head;
	public void push(int x) {
		if (head == null) {
			MSNode n = new MSNode(x,x, null);
			head = n;
			return;
		}
		if (x < head.min) {
			MSNode n = new MSNode(x,x, head);
			head = n;
		} else {
			MSNode n = new MSNode(x, head.min, head);
			head = n;
		}
	}
	
	public void pop() {
		if (head != null) {
			head = head.next;
		}
	}
	
	public int top() {
		if (head != null) {
			return head.data;
		}
		return -1;
	}
	
	public int getMin() {
		if (head != null) {
			return head.min;
		}
		return -1;
	}
}

class MSNode {
	MSNode next;
	int min;
	int data;
	public MSNode(int data, int min) {
		this.data = data;
		this.min = min;
	}
	
	public MSNode(int data, int min, MSNode node) {
		this.data = data;
		this.min = min;
		this.next = node;
	}
	
}
