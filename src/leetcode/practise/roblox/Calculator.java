package leetcode.practise.roblox;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator/discuss/62362/JAVA-Easy-Version-To-Understand!!!!! 
// https://leetcode.com/problems/basic-calculator/
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int sign = 1;
        for (int i=0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = (int)(s.charAt(i) - '0');
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    sum = sum * 10 + (int)(s.charAt(i+1) - '0');
                    i++;
                }
                result = result + sum * sign;
            }
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
            else if (s.charAt(i) == '+') {
                sign = 1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
        }
        return result;
    }
    
    public static int calculate2(String s) {
	int len = s.length(), sign = 1, result = 0;
	Stack<Integer> stack = new Stack<Integer>();
	for (int i = 0; i < len; i++) {
		if (Character.isDigit(s.charAt(i))) {
			int sum = s.charAt(i) - '0';
			while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
				sum = sum * 10 + s.charAt(i + 1) - '0';
				i++;
			}
			result += sum * sign;
		} else if (s.charAt(i) == '+')
			sign = 1;
		else if (s.charAt(i) == '-')
			sign = -1;
		else if (s.charAt(i) == '(') {
			stack.push(result);
			stack.push(sign);
			result = 0;
			sign = 1;
		} else if (s.charAt(i) == ')') {
			result = result * stack.pop() + stack.pop();
		}

	}
	return result;
}

}
