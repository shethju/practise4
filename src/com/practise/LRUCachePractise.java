package com.practise;

import java.util.HashMap;

public class LRUCachePractise {
	HashMap<Integer, DNode> map = new HashMap<>();
	DLL cache;
	int capacity;
	public LRUCachePractise(int capacity) {
		this.capacity = capacity;
		cache = new DLL();
	}
	
	public int get(int key) {
		DNode node = map.get(key);
		if (node == null) return 0;
		cache.delete(node);
		cache.add(node);
		return node.value;
	}
	
	public void put(int key, int value) {
		DNode node = new DNode(key,value);
		DNode tmp = map.get(key);
		//map.remove(key);
		cache.delete(tmp);
		cache.add(node);
		map.put(key, node);
		if (cache.getSize() > capacity) {
			int n = cache.removeTail();
			map.remove(n);
		}
	}
	
	
}

class DLL {
	int size;
	DNode head=null;
	DNode tail = null;
	
	void add(DNode node) {
		if (node == null) return;
		size++;
		if (head == null) {
			head = node;
			tail = node;
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
	}
	
	void delete(DNode node) {
		if (node == null) return;
		size--;
		// only 1 node in list
		if (node.prev == null && node.next == null) {
			head = null;
			tail = null;
			return;
		}
		// head node
		if (node.prev == null && node.next != null) {
			head = node.next;
			head.prev = null;
			return;
		}
		// tail node
		if (node.prev != null && node.next == null) {
			node.prev.next = null;
			tail = node.prev;
			return;
		}
		// middle node
		node.prev.next = node.next;
		node.next.prev = node.prev;
		return;
		
	}
	
	int removeTail() {
		DNode n = tail;
		int val = n.value;
		delete(n);
		return val;
		
	}
	
	int getSize() {
		return size;
	}
}

class DNode {
	int key;
	int value;
	DNode prev;
	DNode next;
	public DNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
