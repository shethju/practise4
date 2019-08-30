package leetcode;

public class IntegerReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int reverse(int x) {
        double res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }
}
