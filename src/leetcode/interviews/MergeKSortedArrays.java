package leetcode.interviews;

class MergeKSortedArrays {
    public ListNode mergeKLists(ListNode[] lists) {
        // corner case
        if(lists == null || lists.length == 0) return null;
        
        ListNode head = merge(lists, 0, lists.length - 1);
        return head;
    }

    // return new head after merging list[left : right]
    public ListNode merge(ListNode[] lists, int left, int right){
        // base case
        if(left == right) return lists[left];
        
        int mid = left + (right - left)/2;
        ListNode l1 = merge(lists, left, mid); // merge [left : mid]
        ListNode l2 = merge(lists, mid + 1, right); // merge [mid + 1 : right]
        
        return mergeTwoLists(l1, l2);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null || cur2 != null){
            if(cur1 == null){
                cur.next = cur2;
                break;
            }else if(cur2 == null){
                cur.next = cur1;
                break;
            }else{
                if(cur1.val <= cur2.val){
                    cur.next = cur1;
                    cur1 = cur1.next;
                }else{
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }
            
        }
     
        return dummy.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int v) {
		this.val = v;
		next = null;
	}
}