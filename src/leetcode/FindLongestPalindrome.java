package leetcode;

public class FindLongestPalindrome {

	public static void main(String args[]) {
		System.out.println(longestPalindrome("abcba"));
	}
	
	public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
		return "";
	}
 
	if (s.length() == 1) {
		return s;
	}
 
	String longest = s.substring(0, 1);
	for (int i = 0; i < s.length(); i++) {
		// Go through each character. Then go to left and right to see if character matches. 
		// get longest palindrome with center of i
		String tmp = helper(s, i, i); // abcba (odd)
		if (tmp.length() > longest.length()) {
			longest = tmp;
		}
 
		// get longest palindrome with center of i, i+1
		tmp = helper(s, i, i + 1); // abba (even)
		if (tmp.length() > longest.length()) {
			longest = tmp;
		}
	}
 
	return longest;
        
    }
    
    // Given a center, either one letter or two letter, 
// Find longest palindrome
	// // Go through each character. Then go to left and right to see if character matches. 
public static String helper(String s, int begin, int end) {
	while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
		begin--;
		end++;
	}
	return s.substring(begin + 1, end); // begin + 1
}
}
