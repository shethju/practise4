package LL;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode temp = head.next; // NOTE total 3 pointers
            head.next = previous;
            previous = head;
            head = temp;
        }
        return previous; // NOTE
    }

    public ListNode reverseList2(ListNode head) { // My solution
        ListNode tmpHead = null;
        ListNode previous = null;
        while (head != null && head.next != null) {
            tmpHead = head;
            head = head.next;
            tmpHead.next = previous;
            previous = tmpHead;

        }
        if (head != null && head.next == null) { // Last iteration
            head.next = previous;
        }
        return head;
    }

    class ListNode {
        ListNode next;

    }
}
