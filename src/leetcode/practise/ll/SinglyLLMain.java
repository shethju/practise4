package leetcode.practise.ll;

public class SinglyLLMain {
	
	public static void main(String args[]) {
		SinglyLL linkedList = new SinglyLL();
		linkedList.addAtHead(1);
		linkedList.addAtTail(3);
		linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
		linkedList.get(1);            // returns 2
		linkedList.deleteAtIndex(1);  // now the linked list is 1->3
		linkedList.get(1);  
	}
	  
}
