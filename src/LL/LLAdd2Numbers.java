package LL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/add-two-numbers/
/**
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 * @author jay_sheth
 *
 */

public class LLAdd2Numbers {
	
	public static ListNodeLong addTwoNumbers(ListNodeLong l1, ListNodeLong l2) {
		long num1 = getNumber(l1);
        long num2 = getNumber(l2);
        long sum = num1 + num2;
        ListNodeLong result = getListNodeLong(sum);
        return result;
    }
	
	private static long getNumber(ListNodeLong l) {
		long result = 0;
		int i=0;
		while (l != null) {
			result = (long) (result + (l.val * (double)Math.pow(10, i)));
			i++;
			l = l.next;
		}
		return result;
	}
	
	private static ListNodeLong getListNodeLong(long sum) {
		int i = 1;
		int divisor = 10;
		ListNodeLong head = null;
		ListNodeLong result = null;
		while (sum/divisor > 0) {
			if (head == null) {
				head = new ListNodeLong(sum % divisor);
				result = head;
			} else {
				ListNodeLong node = new ListNodeLong(sum % divisor);
				head.next = node;
				head = head.next;
			}
			sum = sum/divisor;
		}
		if (head == null) {
			head = new ListNodeLong(sum % divisor);
			result = head;
		} else {
			ListNodeLong node = new ListNodeLong(sum % divisor);
			head.next = node;
			head = head.next;
		}
		return result;
	}
	
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNodeLong stringToListNodeLong(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNodeLong dummyRoot = new ListNodeLong(0);
        ListNodeLong ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNodeLong(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String ListNodeLongToString(ListNodeLong node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Long.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNodeLong l1 = stringToListNodeLong(line);
            line = in.readLine();
            ListNodeLong l2 = stringToListNodeLong(line);
            
            ListNodeLong ret = addTwoNumbers(l1, l2);
            
            String out = ListNodeLongToString(ret);
            
            System.out.print(out);
        }
    }
}

class ListNodeLong {
    ListNodeLong next;
    long val;
    ListNodeLong(long x) {
        val = x;
        next = null;
    }
	

}
