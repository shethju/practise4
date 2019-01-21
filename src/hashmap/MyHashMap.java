package hashmap;

import java.util.LinkedList;

public class MyHashMap {

	private LinkedList<Node>[] arr = new LinkedList[10000];
	/** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashValue = hash(key);
        LinkedList<Node> list = arr[hashValue];
        if (get(key) == -1) {
        		Node n = new Node(key, value);
        		list = new LinkedList<Node>();
        		list.add(n);
        		arr[hashValue] = list;
        } else {
        		for (Node n : list) {
        			if (n.key == key) {
        				n.value = value;
        				return;
        			}
        		}
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    		int hashValue = hash(key);
        LinkedList<Node> list = arr[hashValue];
        if (list == null || list.size() == 0) {
        		return -1;
        } else {
        		for (Node n : list) {
        			if (n.key == key) {
        				return n.value;
        			}
        		}
        	}
        	return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    		if (get(key) == -1) return;
    		int hashValue = hash(key);
        LinkedList<Node> list = arr[hashValue];
        
    		for (Node n : list) {
    			if (n.key == key) {
    				list.remove(n);
    			}
    		}
    }
    
    private int hash(int key) {
    		return key % arr.length;
    }
    
    class Node {
    		int key, value;
    		Node(int key, int value) {
    			this.key = key;
    			this.value = value;
    		}
    }

}
