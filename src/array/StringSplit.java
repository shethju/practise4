package array;

import java.util.Arrays;

public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String linewithLeadingAndTrallingWhiteSpace = "  Java C++  "; 
		// Without trim empty "" is part of array result. Is it because w need equal seperators and values?
		String[] languages = linewithLeadingAndTrallingWhiteSpace.split("\\s+"); 
		String[] languages2 = linewithLeadingAndTrallingWhiteSpace.trim().split("\\s+"); 
		System.out.println("input string: " + linewithLeadingAndTrallingWhiteSpace); 
		System.out.println("output string wihtout trim: " + Arrays.toString(languages)); // prints out in array format [Java, C++]
		System.out.println("output string after trim() and split: " + Arrays.toString(languages2));
		/*
		 * 
input string:   Java C++ 
output string wihtout trim: [, Java, C++]
output string after trim() and split: [Java, C++]
		 */
		//Read more: https://javarevisited.blogspot.com/2016/10/how-to-split-string-in-java-by-whitespace-or-tabs.html#ixzz5z6ZL3Lu2
	}

}
