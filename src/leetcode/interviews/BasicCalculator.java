package leetcode.interviews;
// https://leetcode.com/problems/basic-calculator-ii/  

import java.util.Stack;

public class BasicCalculator {
	public static void main(String args[]) {
		System.out.println(calculate("2+5*3"));
		System.out.println(calculate2("2+5*3"));
	}

	public static int calculate(String s) {
        int N = s.length();
        char sign = '+';
        int pre = 0;
        int res = 0;
        int num = 0;
        for (int i = 0; i < N; i++) {
          char ch = s.charAt(i);
          boolean isDigit = Character.isDigit(ch);
          if (isDigit) {
            num = num * 10 + (ch - '0');
          }

          if ((!isDigit && ch != ' ') || i == N - 1) {
            switch (sign) {
              case '+': {
                res += pre;
                pre = num;
                break;
              }
              case '-': {
                res += pre;
                pre = -num;
                break;
              }
              case '/': {
                pre = pre / num;
                break;
              }
              case '*': {
                pre = pre * num;
                break;
              }
            }
            num = 0;
            sign = ch;
          }
        }
        return pre + res;
    }
	
	public static int calculate2(String s) {
	    int len;
	    if(s==null || (len = s.length())==0) return 0;
	    Stack<Integer> stack = new Stack<Integer>();
	    int num = 0;
	    char sign = '+';
	    for(int i=0;i<len;i++){
	        if(Character.isDigit(s.charAt(i))){
	            num = num*10+s.charAt(i)-'0';
	        }
	        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){ // i = len-1
	            if(sign=='-'){
	                stack.push(-num);
	            }
	            if(sign=='+'){
	                stack.push(num);
	            }
	            if(sign=='*'){
	                stack.push(stack.pop()*num);
	            }
	            if(sign=='/'){
	                stack.push(stack.pop()/num);
	            }
	            sign = s.charAt(i); // imp
	            num = 0; // imp
	        }
	    }

	    int re = 0;
	    for(int i:stack){
	        re += i;
	    }
	    return re;
	}
}
