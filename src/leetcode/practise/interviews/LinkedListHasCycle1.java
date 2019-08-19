package leetcode.practise.interviews;

// https://leetcode.com/problems/linked-list-cycle/solution/
// Note that the cycle can be from any random node in ll not necessary the 1st node
public class LinkedListHasCycle1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
	    if (head == null || head.next == null) { // single node
	        return false;
	    }
	    ListNode slow = head;
	    ListNode fast = head.next;
	    while (slow != fast) {
	        if (fast == null || fast.next == null) { // termination condition
	            return false;
	        }
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    return true; // at this point slow == fast hence return true
	}
	
	public boolean hasCycle2(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }
}
