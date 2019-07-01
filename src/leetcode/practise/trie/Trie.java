package leetcode.practise.trie;

import java.util.HashMap;

public class Trie {
	
	class TrieNode {
		HashMap<Character, TrieNode> children;
		boolean isWordComplete;
	}
	
	TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	
	/** Inserts a word into the trie. */
    public void insert(String word) {
    		TrieNode cur = root;
    		char[] characters = word.toCharArray();
    		for (char c: characters) {
    			if (cur.children.get(c) == null) {
    				cur.children.put(c, new TrieNode());
    			}
    			cur = cur.children.get(c);
    		}
    		cur.isWordComplete = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    		TrieNode cur = root;
    		for (int i= 0; i < word.length(); i++) {
    			char c = word.charAt(i);
    			if (cur.children.get(c) == null) {
    				return false;
    			}
    			cur = cur.children.get(c);
    		}
    		return cur.isWordComplete;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
    		TrieNode cur = root;
		for (int i= 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.children.get(c) == null) {
				return false;
			}
			cur = cur.children.get(c);
		}
		return true;
    		
    }
}
