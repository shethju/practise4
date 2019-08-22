package leetcode;

/*
 * https://leetcode.com/problems/valid-number/discuss/23738/Clear-Java-solution-with-ifs
 * 
 * Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one. 
However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."

We start with trimming.

If we see [0-9] we reset the number flags.
We can only see . if we didn't see e or ..
We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
We can only see + and - in the beginning and after an e
any other character break the validation.
At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.

So basically the number should match this regular expression:

[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
 * 
 */
public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumberMy(" 005047e+6"));
	}
	
	public static boolean isNumberMy(String s) {
        if (s == null || s.trim().length() == 0) return false;
        s = s.trim();
        boolean isnum = false;
        boolean isEseen = false;
        boolean isNumAfterE = true;
        boolean ispoint = false;
        
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <='9') {
                isNumAfterE = true;
                isnum = true;
            }
            else if (c == '.') {
                if (isEseen || ispoint) return false;
                ispoint = true;
            }
            else if (c == '+' || c == '-') {
                if (i != 0 || (i-1 >=0 && s.charAt(i-1) != 'e')) return false;
            }
            else if (c == 'e') {
                if (isEseen || !isnum) return false;
                isNumAfterE = false;
                isEseen = true;
            } else {
                return false;
            }
        }
        return isnum && isNumAfterE;
            
    }
	
	public boolean isNumber(String s) {
	    s = s.trim();
	    
	    boolean ispoint = false;
	    boolean isEseen = false;
	    boolean isnum = false;
	    boolean isNumAfterE = true;
	    for(int i=0; i<s.length(); i++) {
	        if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
	            isnum = true;
	            isNumAfterE = true;
	        } else if(s.charAt(i) == '.') {
	            if(isEseen || ispoint) {
	                return false;
	            }
	            ispoint = true;
	        } else if(s.charAt(i) == 'e') {
	            if(isEseen || !isnum) {
	                return false;
	            }
	            isNumAfterE = false;
	            isEseen = true;
	        } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
	            if(i != 0 && s.charAt(i-1) != 'e') {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }
	    
	    return isnum && isNumAfterE;
	}

}
