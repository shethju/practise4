package leetcode.practise.ll;

public class DoublyLL {
	
	Node head; // head of list 
	  
    /* Doubly Linked list Node*/
    class Node { 
        int data; 
        Node prev; 
        Node next; 
  
        // Constructor to create a new node 
        // next and prev is by default initialized as null 
        Node(int d) { data = d; } 
    } 

	// Adding a node at the front of the list 
    public void push(int new_data) {
    		Node n = new Node(new_data);
    		if (head == null) {
    			head = n;
    			n.next = null;
    		} else {
    			n.next = head;
    			head.prev = n;
    			head = n;
    		}
    }
    
    /* Given a node as prev_node, insert a new node after the given node */
    public void InsertAfter(Node prev_Node, int new_data) {
    		Node n = new Node(new_data);
    		Node temp = prev_Node.next;
    		if (temp == null) {
    			prev_Node.next = n;
    			n.prev = prev_Node;
    		} else {
    			n.next = temp;
    			n.prev = prev_Node;
    			prev_Node.next = n;
    			temp.prev = n;
    		}
    }
    
    // Add a node at the end of the list 
    void append(int new_data) {
    		Node n = new Node(new_data);
    		if (head == null) {
    			head = n;
    			return;
    		}
    		Node temp = head;
    		while (temp.next != null) {
    			temp = temp.next;
    		}
    		temp.next = n;
    		n.prev = temp;
    }
    
 // This function prints contents of linked list starting from the given node 
    public void printlist(Node node) {
    		while (node != null) {
    			System.out.println(node.data);
    			node = node.next;
    		}
    }
    
    /* Drier program to test above functions*/
    public static void main(String[] args) 
    { 
        /* Start with the empty list */
        DoublyLL DoublyLL = new DoublyLL(); 
  
        // Insert 6. So linked list becomes 6->NULL 
        DoublyLL.append(6); 
  
        // Insert 7 at the beginning. So linked list becomes 7->6->NULL 
        DoublyLL.push(7); 
  
        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL 
        DoublyLL.push(1); 
  
        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL 
        DoublyLL.append(4); 
  
        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL 
        DoublyLL.InsertAfter(DoublyLL.head.next, 8); 
  
        System.out.println("Created DoublyLL is: "); 
        DoublyLL.printlist(DoublyLL.head); 
    } 
}
