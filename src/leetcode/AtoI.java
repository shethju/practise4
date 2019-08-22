package leetcode;

/*
 * Convert string to integer
 * https://leetcode.com/problems/string-to-integer-atoi/submissions/ 
 * Input: "4193 with words"
	Output: 4193
	
	Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
 */
public class AtoI {
	public int myAtoi(String str) {
	    str = str.trim();
	        
	        if (str == null || str.length() == 0) {
	            return 0;
	        }
	        
	        double result = 0;
	        
	        // handle positive and negative sign
	        boolean isNegative = false;
	        int startIndex = 0; // index of first numerical character
	        
	        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
	            startIndex++;
	        }
	        if (str.charAt(0) == '-') {
	            isNegative = true;
	        }
	        
	        // handle normal case "123"
	        for (int i = startIndex; i < str.length(); i++) {
	            // handle non-numerical character
	            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
	                break;
	            }
	            int digitValue = (int)(str.charAt(i) - '0'); // '9' - '0' 
	            result = result * 10 + digitValue;
	        }
	        
	        if (isNegative) {
	            result = -result;
	        }
	        
	        // handle out of Integer range
	        if (result > Integer.MAX_VALUE) {
	            return Integer.MAX_VALUE;
	        }
	        if (result < Integer.MIN_VALUE) {
	            return Integer.MIN_VALUE;
	        }
	 
	        return (int)result;
	    }

}
