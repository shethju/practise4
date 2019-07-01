package leetcode.practise.recursion;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strReverse("12345"));
	}

	private static String strReverse(String s) {
		if (s.length() < 2) return s;
		return strReverse(s.substring(1, s.length())) + s.charAt(0);
	}
}
