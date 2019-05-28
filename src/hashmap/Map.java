package hashmap;

import java.util.ArrayList;
import java.util.List;

public class Map<K,V> {
	private int numBuckets;
	private int size;
	private List<Node<K,V>> bucket;
	/*public Map(K key, V value) {
		
		bucket = new ArrayList<>();  
		numBuckets = 10;
		size = 0;
		for (int i=0; i < numBuckets; i++) {
			bucket.add(null);
		}
	}*/
	
	public Map() {
		// TODO Auto-generated constructor stub
		bucket = new ArrayList<>();  
		numBuckets = 10;
		size = 0;
		for (int i=0; i < numBuckets; i++) {
			bucket.add(null);
		}
	}

	public int size() { return size; }
	public boolean isEmpty() { return size == 0 ? true : false; }
	
	private int findBucketIndex(K key) {
		return key.hashCode() % numBuckets;
	}
	
	public V remove(K key) {
		int bucketIndex = findBucketIndex(key);
		Node<K,V> head = bucket.get(bucketIndex);
		Node<K,V> previous = null;
		while (head != null) {
			if (head.key == key) {
				if (previous != null) {
					previous.next = head.next;
					size--;
					return head.value;
				}
				else {
					bucket.set(bucketIndex, head.next);
					size--;
					return head.value;
				}
			}
			previous = head;
			head = head.next;
		}
		return null;
	}
	
	public V getKey(K key) {
		int bucketIndex = findBucketIndex(key);
		Node<K,V> head = bucket.get(bucketIndex);
		while (head != null) {
			if (head.key == key) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	public void add(K key, V value) {
		int bucketIndex = findBucketIndex(key);
		Node<K,V> head = bucket.get(bucketIndex);
		while (head != null) {
			if (head.key == key) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		head = bucket.get(bucketIndex);
		Node<K,V> n = new Node<K,V>(key,value);
		n.next = head;
		bucket.set(bucketIndex, n);
		if ((1.0 * size/ numBuckets) >= 0.7) {
			List<Node<K,V>> temp = bucket;
			bucket = new ArrayList<Node<K,V>>();
			numBuckets = numBuckets * 2;
			for (int i = 0; i < numBuckets ; i++) {
				bucket.add(null);
			}
			size = 0; //important	
			for (Node<K,V> n1 : temp) {
				while (n1 != null) { //iterate through and rehash all nodes
					add(n1.key, n1.value);
					n1 = n1.next;
				}
			}
		}
	}
	
	
}