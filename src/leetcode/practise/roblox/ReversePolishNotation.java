package leetcode.practise.roblox;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		evalRPN(s);
	}

	public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        Integer result = 0;
        for (String s : tokens) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(s);
            } else {
                Integer op1 = Integer.parseInt(stack.pop());
                Integer op2 = Integer.parseInt(stack.pop());
                switch (s.charAt(0)) {
                    case '+':
                        result = op1 + op2;
                        stack.push(result.toString());
                        break;
                    case '-':
                        result = op1 - op2;
                        stack.push(result.toString());
                        break;
                    case '/':
                        result = op1 / op2;
                        stack.push(result.toString());
                        break;
                    case '*':
                        result = op1 * op2;
                        stack.push(result.toString());
                        break;    
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
