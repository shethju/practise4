package leetcode.practise.interviews;

// https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
public class IntersectionOf2LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Visualization 
	// https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!/165648
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) return null;
	    
	    ListNode a = headA;
	    ListNode b = headB;
	    
	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }
	    
	    return a;
	}
}
