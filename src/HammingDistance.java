
public class HammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Yes, XOR! Also, do not forget there is a decent function Java provided: Integer.bitCount() ~~~
	 * The bitCount() method of Integer class of java.lang package returns the count of the number of one-bits 
	 * in the two's complement binary representation of an int value. This function is sometimes referred to as 
	 * the population count
	 */
	public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}
