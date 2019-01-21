package com.udemy;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 2, 1, 4,5};
		System.out.print(firstRecur(arr));
	}

	private static int firstRecur(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (Integer i: arr) {
			if (set.contains(i)) {
				return i;
			}
			set.add(i);
		}
		return -1;
	}
}
