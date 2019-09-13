package leetcode.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//IheartRadio
/*
 * 1. Word printed in sorted order
 * 2. 1st word alphabet has to be capital
 * 3. if 2 words same length then maintain order as in string 
 */
public class WordSortingInString {
	public static void main(String[] args) {
		String s = "The lines are printed in reverse order."; // expected: In the are lines order printed reverse.
		String s2 = "Here i come."; // expected: I here come.
		System.out.println(arrange(s2)); 
	}
	
	public static String arrange(String sentence) {
	        TreeMap<Integer, List<String>> map = new TreeMap<>();
	        int length = sentence.length();
	        String[] arr = sentence.substring(0, length-1).split(" ");
	        StringBuffer result = new StringBuffer();
	        for (int i=0; i < arr.length; i++) {
	        		String s = arr[i];
	        		List<String> list = map.get(s.length());
	        		if (map.get(s.length()) == null) {
	        			list = new ArrayList<>();
	        		}
	        		list.add(s.toLowerCase()); // all to lowercase so dont need to find 1st word and make it lower case if rearranged
	        		map.put(s.length(), list);
	        }
	        // capitalize 1st character of 1st word of smallest length
	        Map.Entry<Integer, List<String>> item = map.firstEntry();
	        List<String> list = item.getValue();
	        String s = list.get(0);
	        list.add(0, Character.toString(s.charAt(0)).toUpperCase() + s.substring(1, s.length()));
	        list.remove(1);
	        map.put(item.getKey(), list);
	        // 
	        int i1 = 0;
	        for (Map.Entry<Integer, List<String>> i: map.entrySet()) {
	        		List<String> str = i.getValue();
	        		int j = 0;
	        		for (String tmp: str) {
	        			result.append(tmp);
	        			if (!(i1 == map.size() -1 && j == str.size() - 1)) // last word of string dont append " "
	        			result.append(" ");
	        			j++;
	        		}
	        		i1++;
	        }
	        result.append(".");
	        return result.toString();
	    }
	
	
}
