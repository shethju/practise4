package leetcode.practise.map;

import hashmap.Map;

public class MapMain {

	public static void main(String[] args) 
	{ 
		//Map<String, Integer>map = new Map<>("abc",1); 
		Map<String, Integer>map = new Map<>();
		map.add("this",1 ); 
		map.add("coder",2 ); 
		map.add("this",4 ); 
		map.add("hi",5 ); 
		System.out.println(map.size()); 
		System.out.println(map.remove("this")); 
		System.out.println(map.remove("this")); 
		System.out.println(map.size()); 
		System.out.println(map.isEmpty()); 
	} 
}
