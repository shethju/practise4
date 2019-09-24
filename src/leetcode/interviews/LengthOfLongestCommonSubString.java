package leetcode.interviews;

// https://www.geeksforgeeks.org/print-longest-common-substring/
/**
 * 
 * Input :  X = "GeeksforGeeks", 
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

}
