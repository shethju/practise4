package leetcode.practise.ll;

import java.util.concurrent.PriorityBlockingQueue;

public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q=new Q(); 
        q.enqueue(10); 
        q.enqueue(20); 
        q.dequeue(); 
        q.dequeue(); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50);
        System.out.println("Dequeued item is "+ q.Front());
    }

	
}

class Q {
	Node1 head, tail;
	int size = 0;
	
	/** Insert an element into the queue. Return true if the operation is successful. */
    public boolean enqueue(int x) {
    		Node1 n = new Node1(x);
    		size++;
    		if (head == null) {
    			head = n;
    			tail = n;
    			return true;
    		} else {
    			tail.next = n;
    			tail = n;
    			return true;
    		}
    }
    
    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean dequeue() {
    		if (head != null) {
    			head = head.next;
    			size--;
    		}
    		return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    		if (head != null) {
    			return head.data;
    		}
    		return -1;
    }
    
    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
    		return size > 0 ? false : true;
    }
}

class Node1 {
	Node1 next;
	int data;
	public Node1 (int data) { this.data = data; }
}
