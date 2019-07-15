package leetcode.top100;

// https://leetcode.com/problems/longest-palindromic-substring/
// In fact, we could solve it in O(n^2) time using only constant space. O(n square)
public class LongestPalindromicSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Approach 4: Expand Around Center
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        String result = s.substring(0,1);
        for (int i=0; i < s.length(); i++) {
            String tmp = helper(s,i,i); // odd number of characters
            if (tmp.length() > result.length()) {
                result=tmp;
            }
            tmp = helper(s,i,i+1);
            if (tmp.length() > result.length()) { // even number of characters
                result=tmp;
            }
        }
        return result;
    }
    
    private String helper(String s, int i, int j) {
        while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}
