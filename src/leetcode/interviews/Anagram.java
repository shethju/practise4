package leetcode.interviews;

import java.util.Collection;
import java.util.HashMap;

// If 2 words are anagram of each other
public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("abc", "abe"));
	}
	
	private static boolean isAnagram(String s1, String s2) 
	{
		if ((s1 == null) && (s2 != null)) return false;
		if (s1 != null && s2 == null) return false;
		if (s1.length() != s2.length()) return false;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i=0; i < s1.length(); i++) {
			int count = map.getOrDefault(s1.charAt(i), 0);
			count = count + 1;
			map.put(s1.charAt(i), count);
		}
		for (int i=0; i < s2.length(); i++) {
			int count = map.getOrDefault(s2.charAt(i), 0);
			if (count == 0) return false; // important e.g. aab, abc
			count = count - 1;
			map.put(s1.charAt(i), count);
		}
		for (Integer value: map.values()) {
			if (value >= 1) return false;
		}
		return true;
	}

}
