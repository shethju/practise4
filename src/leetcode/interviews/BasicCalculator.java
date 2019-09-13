package leetcode.interviews;
// https://leetcode.com/problems/basic-calculator-ii/  
	
public class BasicCalculator {
	public static void main(String args[]) {
		System.out.print(calculate("5-3"));
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
}
