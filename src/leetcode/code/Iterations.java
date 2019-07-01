package leetcode.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Iterations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maps();
	}

	private static void maps() {
		Map<String,String> gfg = new HashMap<String,String>(); 
	      
        // enter name/url pair 
        gfg.put("GFG", "geeksforgeeks.org"); 
        gfg.put("Practice", "practice.geeksforgeeks.org"); 
        gfg.put("Code", "code.geeksforgeeks.org"); 
        gfg.put("Quiz", "quiz.geeksforgeeks.org");
     // using for-each loop for iteration over Map.entrySet() 
        for (Entry<String,String> entry : gfg.entrySet())  // Map.Entry
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
     // using keySet() for iteration over keys 
        for (String name : gfg.keySet())  
            System.out.println("key: " + name); 
          
        // using values() for iteration over keys 
        for (String url : gfg.values())  
            System.out.println("value: " + url); 
        
     // looping over keys 
        for (String name : gfg.keySet())  
        { 
            // search  for value 
            String url = gfg.get(name); 
            System.out.println("Key = " + name + ", Value = " + url); 
        } 
	}
	
	private static void lists() {
		
		
	}
}
