package leetcode.practise.ll;

public class SinglyLL {
    Node head;
    int size;
    /** Initialize your data structure here. */
    public SinglyLL() {
        head = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (i == index) {
                return temp.val;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = null;
        size++;
        if (head == null) {
            head = n;
            return;
        } else {
            n.next = head;
            head = n;
        }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        size++;
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size + 1) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (i == index - 1) {
                Node n = new Node(val);
                n.next = temp.next;
                temp.next = n;
                size++;
                return;
            }
            temp = temp.next;
            i++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index <= size -1 && index >=0) {
            Node temp = head;
            int i = 0;
            // if deleting head
            if (index == 0) {
                if (size > 0) {
                    head = head.next;
                    size--;
                    return;
                }
            }
            while (temp != null) {
                if (i == index-1) {
                    Node n = temp.next;
                    if (n != null) {
                        temp.next = n.next;
                    } else {
                        temp.next = null;
                    }
                    size--;
                    return;
                }
                temp = temp.next;
                i++;
            }
        }
    }
    
    public Node reverseList(Node head) {
        Node prev = null;
        Node next = null;
        Node current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

class Node {
    Node next;
    int val;
    Node(int v) {
        this.val = v;
    }
}

/**
 * Your SinglyLL object will be instantiated and called as such:
 * SinglyLL obj = new SinglyLL();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
/**
 * Your SinglyLL object will be instantiated and called as such:
 * SinglyLL obj = new SinglyLL();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */