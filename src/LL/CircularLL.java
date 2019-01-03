package LL;

public class CircularLL {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        boolean hasCycle = false;
        ListNode fastPtr = head;
        while (head!= null && head.next != null && fastPtr.next != null && fastPtr.next.next != null) { // head!=null
            if (head.next == fastPtr.next.next) return true;
            head = head.next;
            fastPtr = fastPtr.next.next;
        }
        return hasCycle;
    }
}

class ListNode {
    ListNode next;
    int val;
    ListNode(int x) {
        val = x;
        next = null;
    }
	

}
