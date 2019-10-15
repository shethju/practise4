package leetcode.interviews;

import java.util.LinkedList;
import java.util.List;

// https://www.geeksforgeeks.org/print-longest-common-substring/
// longest common substring https://youtu.be/tABtJbLOQho 
/**
 * 
 * 
Input :  X = "GeeksforGeeks", 
         Y = "GeeksQuiz"
Output : Geeks

Input : X = "zxabcdezy", 
        Y = "yzabcdezx"
Output : abcdez
 *
 */
public class LengthOfLongestCommonSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcde";
		String s2 = "aabcxyz";
		System.out.println(getLongestSubString(s1,s2));
		System.out.println(longestCommonSubString(s1,s2));
	}
	
	private static int getLongestSubString(String s1, String s2) {
		int len1 = s1.length() -1;
		int len2 = s2.length() - 1;
		if (len1 > len2) return getLongestSubString(s2, s1);
		int count = 0;
		for (int i=0; i <= len1; i++) {
			for (int j=0; j <= len2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					int subCount = 1;
					count = Math.max(count, subCount);
					for (int l = 1; l+i <= len1; l++) {
						if (s1.charAt(i+l) == s2.charAt(j+l)) {
							subCount++;
							count = Math.max(count, subCount);
						} else {
							count = Math.max(count, subCount);
							break;
						}
					}
				}
			}
		}
		return count;
	}

	public static List<String> longestCommonSubString(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		Integer map[][] = new Integer[len1][len2];
		Integer max = Integer.MIN_VALUE;
		List<String> result = new LinkedList<>();
		for (int i=0; i < len1; i++) {
			for (int j=0; j < len2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i == 0 || j == 0) map[i][j] = 1;
					else map[i][j] = map[i-1][j-1] + 1;
					if (map[i][j] > max) {
						max = map[i][j];
						result = new LinkedList<>();
						result.add(s1.substring(i+1-max, i+1));
					} else if (map[i][j] == max) {
						result.add(s1.substring(i+1-max, i+1));
					}
				} else {
					map[i][j] = 0;
				}
			}
		}
		return result;
	}
}
