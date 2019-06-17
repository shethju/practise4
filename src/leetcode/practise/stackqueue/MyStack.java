package leetcode.practise.stackqueue;

import java.util.ArrayList;
import java.util.List;

//"static void main" must be defined in a public class.
class Stack {
     List<Integer> list;
	 public Stack() {
	     list = new ArrayList<Integer>();
	 }
	 
	 /** Insert an element into the stack. */
	 public void push(int x) {
	     list.add(x);
	 }
	 /** Checks whether the queue is empty or not. */
	 public boolean isEmpty() {
	     return (list.size() > 0) ? false : true;
	 }
	 /** Get the top item from the queue. */
	 public int top() {
	     return list.get(list.size() - 1);
	 }
	 
	 /** Delete an element from the queue. Return true if the operation is successful. */
	 public boolean pop() {
		 if (list.size() <= 0) return false;
		 list.remove(list.size() - 1);
		 return true;
	 }
}



public class MyStack {
 public static void main(String[] args) {
     Stack s = new Stack();
     s.push(1);
     s.push(2);
     s.push(3);
     for (int i = 0; i < 4; ++i) {
         if (!s.isEmpty()) {
             System.out.println(s.top());
         }
         System.out.println(s.pop());
     }
 }
}