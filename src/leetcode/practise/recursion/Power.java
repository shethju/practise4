package leetcode.practise.recursion;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2,6));
	}

	private static int pow(int a, int b) {
		if (b == 1) return a;
		return a * pow(a, b-1);
	}
}
