package leetcode.practise.string;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubString("abcabcbb"));
		System.out.println(lengthOfLongestSubString("aa"));
		System.out.println(lengthOfLongestSubString("a"));
		System.out.println(lengthOfLongestSubString("abb"));
	}
	
	private static int lengthOfLongestSubString(String s) {
		HashSet<Character> set = new HashSet<>();
		int ans = 0;
		int length = s.length()-1;
		for (int i=0, j=0; j <= length && i <= length; ) {
			char c = s.charAt(j);
			if (!set.contains(c)) {
				set.add(c);
				j++;
				ans = Math.max(ans, j-i);
			} else {
				set.remove(c);
				i++;
			}
		}
		return ans;
	}

}
