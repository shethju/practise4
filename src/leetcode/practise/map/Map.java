package leetcode.practise.map;

import java.util.ArrayList;
import java.util.List;

public class Map<K,V> {
	private int numbuckets;
	private int size;
	private List<Node<K,V>> buckets;
	
	public Map() {
		numbuckets = 10;
		size = 0;
		buckets = new ArrayList<>();
		for (int i = 0; i < numbuckets; i++) {
			buckets.add(null);
		}
	}
	
	private int findIndex(K key) {
		return key.hashCode() % numbuckets;
	}
	
	public boolean isEmpty() {
		return size > 0 ? false : true;
	}
	
	public V remove(K key) {
		int index = findIndex(key);
		Node<K,V> n = buckets.get(index);
		Node<K,V> prev = null;
		if (n != null) {
			if (n.key == key) {
				size--;
				if (prev == null) {
					buckets.set(index, n.next);
					return n.value;
				}
				prev.next = n.next;
				return n.value;
			}
			prev = n;
			n = n.next;
		}
		return null;
	}
	
	public V getKey(K key) {
		int index = findIndex(key);
		Node<K,V> n = buckets.get(index);
		if (n != null) {
			if (n.key == key) {
				return n.value;
			}
			n = n.next;
		}
		return null;
	}
	
	public void add(K key, V value) {
		int index = findIndex(key);
		Node<K,V> n = buckets.get(index);
		if (n == null) {
			Node<K,V> tmp = new Node(key, value);
			buckets.set(index, tmp);
			size++;
			return;
		}
		while (n != null) {
			if (n.key == key) {
				n.value = value;
				return;
			}
			n = n.next;
		}
		n = buckets.get(index);
		Node<K,V> tmp = new Node(key, value);
		tmp.next = n;
		buckets.set(index, tmp);
		size++;
		if ((1.0 * size) / numbuckets > 0.7) {
			List<Node<K,V>> tmpList = buckets;
			buckets = new ArrayList<Node<K,V>>();
			size = 0;
			numbuckets = numbuckets * 2;
			for (int i = 0; i < numbuckets; i++) {
				buckets.add(null);
			}
			for (int i=0; i < numbuckets; i++) {
				Node<K,V> tmpNode = buckets.get(i);
				while (tmpNode != null) {
					add(tmpNode.key, tmpNode.value);
					tmpNode = tmpNode.next;
				}
			}
		}
	}

}

class Node<K,V> {
	Node<K,V> next;
	K key;
	V value;
	public Node(K key, V value) { // Wrong - Node<K,V>
		this.key = key;
		this.value = value;
	}
}
