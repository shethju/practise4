package leetcode.practise.recursion;

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("12345"));
		System.out.println(isPalindrome("12321"));
		System.out.println(isPalindrome("1"));
		System.out.println(isPalindrome("12"));
		System.out.println(isPalindrome("11"));
		System.out.println(isPalindrome("111"));
	}

	private static boolean isPalindrome(String s) {
		if (s.length() < 2) return true;
		if (s.charAt(0) != s.charAt(s.length() -1)) return false;
		return isPalindrome(s.substring(1, s.length() -1));
	}
}
