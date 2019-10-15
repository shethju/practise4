package leetcode.interviews;

import java.util.ArrayList;
import java.util.Stack;
// valid parenthesis parantheses brackets
public class ValidParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> strings = new ArrayList<String>();
	    strings.add("[adafdaf{adafa}adaff]");
	    strings.add("{adfadfa[adafdfa}dfafaf]");
	    strings.add(null);
	    strings.add("");
	    strings.add("hello");
	    strings.add("{}P{}{{");
	    strings.add("{");
	    //strings.add("This pad is running Java " + Runtime.version().feature());

	    for (String string : strings) {
	      System.out.println(isValid(string));
	    }


	}
	
	private static boolean isValid(String s) {
	    if (s == null) return false;
	    Stack<Character> stack = new Stack<Character>();
	    for (char c: s.toCharArray()) {
	      if (c == '(') {
	        stack.push(')');
	      } else if (c == '{') {
	        stack.push('}');
	      } else if (c == '[') {
	        stack.push(']');
	      } else if (isBracket(c) && (stack.isEmpty() || stack.pop() != c)) {
	        return false;
	      } 
	    }
	    return stack.isEmpty();
	  }
	  
	  private static boolean isBracket(Character c) {
	    if (c == ')' || c == '}' || c == ']') return true;
	    else return false;
	  }
	}