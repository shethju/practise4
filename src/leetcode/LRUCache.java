package leetcode;

import java.util.HashMap;

class LRUCache {
	HashMap<Integer, DNode> map;
	DLL cache;
	int capacity;
    public LRUCache(int capacity) {
    		map = new HashMap<>();
    		this.capacity = capacity;
    		cache = new DLL();
    }
    
    public int get(int key) {
        DNode n = map.get(key);
        if (n == null) return -1;
        cache.remove(n);
        cache.add(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        DNode n = new DNode(key, value);
        cache.remove(map.get(key)); // this needs to be before put else we remove the same one we added
        map.put(key, n);
        cache.add(n);
        if (cache.getSize() > capacity) {
        		DNode tail = cache.removeTail();
        		map.remove(tail.key);
        }
    }
}

class DNode {
	int key;
	int value;
	DNode previous;
	DNode next;
	DNode(int key, int value) {
		this.value = value;
		this.key = key;
	}
}

class DLL { // doubly linked list
	int size = 0;
	DNode head = null;
	DNode tail = null;
	void add(DNode n) {
		if (n == null) return;
		size++;
		// 1st node
		if (head == null) {
			n.previous = null;
			n.next = null;
			head = n;
			tail = n;
			return;
		}
		// 2nd node onwards
		head.previous = n;
		n.next = head;
		n.previous = null;
		head = n;
	}
	
	void remove(DNode n) {
		if (n == null) return;
		size--;
		// 1 node
		if (n.previous == null && n.next == null) {
			head = null;
			tail = null;
			return;
		}
		// tail node
		if (n.next == null && n.previous != null) {
			n.previous.next = null;
			tail = n.previous;
			return; // important
		}
		// head node
		if (n.previous == null && n.next != null) {
			head = n.next;
			head.previous = null;
			return;
		}
		// middle node
		n.previous.next = n.next;
		n.next.previous = n.previous;
	}
	
	DNode removeTail() {
		DNode temp = this.tail;
		//tail = tail.previous;
		remove(temp);
		//size--;
		return temp;
	}
	
	public int getSize() {
		return this.size;
	}
	
}