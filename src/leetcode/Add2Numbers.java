package leetcode;

// https://leetcode.com/problems/add-two-numbers/
public class Add2Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       ListNode result = null, head = null;
	        //ListNode head = null;
	        int carry = 0;
	        while (l1 != null || l2 != null) { // or condition since we can have carry forward
	        		int l1Val = l1 == null ? 0 : l1.val; // null check
	        		int l2Val = l2 == null ? 0 : l2.val;
	        		int sum = l1Val + l2Val + carry;
	        		carry = sum/10;
	        		ListNode n = new ListNode(sum % 10);
	        		if (result == null) {
	        			result = n;
	        			head = n;
	        		} else {
	        			result.next = n;
	                result = n;// move result
	        		}
	        		if (l1 != null) l1 = l1.next; // null check
	        		if (l2 != null) l2 = l2.next;
	        }
	        if (carry == 1) {
	        		result.next = new ListNode(1);
	        }
	        return head; 
	 }

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }      
}
