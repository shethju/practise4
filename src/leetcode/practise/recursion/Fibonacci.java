package leetcode.practise.recursion;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(5));
		System.out.println(fib(6));
	}
	
	private static int fib(int n) {
		if (n < 2) return 1;
		return n * fib(n-1);
	}

}
