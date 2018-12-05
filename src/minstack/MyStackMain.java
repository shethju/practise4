package minstack;

public class MyStackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<String> my = new MyStack<String>();
		my.print();
		System.out.println("minvalue " + my.getMinValue());
		my.push("abc3");
		System.out.println("minvalue " + my.getMinValue());
		my.push("abc1");
		System.out.println("minvalue " + my.getMinValue());
		my.push("abc2");
		my.print();
		System.out.println("minvalue " + my.getMinValue());
		System.out.println("peek " + my.peek());
		System.out.println("isEmpty value " + my.empty());
		System.out.println("pop value " + my.pop());
		System.out.println("pop value " + my.pop());
		System.out.println("pop value " + my.pop());
		System.out.println("pop value " + my.pop());
		my.print();
		System.out.println("isEmpty value " + my.empty());
		my.print();
		my.peek();
	}

}
