package leetcode.practise.interviews;



	
	import java.io.*;
	import java.util.*;

	/*
	You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

	Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.

	Sample Input:

	student_course_pairs_1 = [
	  ["58", "Software Design"],
	  ["58", "Linear Algebra"],
	  ["94", "Art History"],
	  ["94", "Operating Systems"],
	  ["17", "Software Design"],
	  ["58", "Mechanics"],
	  ["58", "Economics"],
	  ["17", "Linear Algebra"],
	  ["17", "Political Science"],
	  ["94", "Economics"],
	  ["25", "Economics"],
	]

	Sample Output (pseudocode, in any order):

	find_pairs(student_course_pairs_1) =>
	{
	  [58, 17]: ["Software Design", "Linear Algebra"]
	  [58, 94]: ["Economics"]
	  [58, 25]: ["Economics"]
	  [94, 25]: ["Economics"]
	  [17, 94]: []
	  [17, 25]: []
	}

	Additional test cases:

	Sample Input:

	student_course_pairs_2 = [
	  ["42", "Software Design"],
	  ["0", "Advanced Mechanics"],
	  ["9", "Art History"],
	]

	Sample output:

	find_pairs(student_course_pairs_2) =>
	{
	  [0, 42]: []
	  [0, 9]: []
	  [9, 42]: []
	}

	 */

	class StudentCoursesCommon {
	  public static void main(String[] args) {
	    String[][] studentCoursePairs1 = {
	      {"58", "Software Design"},
	      {"58", "Linear Algebra"},
	      {"94", "Art History"},
	      {"94", "Operating Systems"},
	      {"17", "Software Design"},
	      {"58", "Mechanics"},
	      {"58", "Economics"},
	      {"17", "Linear Algebra"},
	      {"17", "Political Science"},
	      {"94", "Economics"},
	      {"25", "Economics"}
	    };

	    String[][] studentCoursePairs2 = {
	      {"42", "Software Design"},
	      {"0", "Advanced Mechanics"},
	      {"9", "Art History"},
	    };
	    
	    // TODO: Call your function and print your results
	    Map<StudentPair, List<String>> result = findCourses(studentCoursePairs1);
	    for (Map.Entry<StudentPair, List<String>> entry : result.entrySet()) {
	    		StudentPair key = entry.getKey();
	    		List<String> values = entry.getValue();
	    		System.out.println("[" + key.student1 + "," + key.student2);
	    		System.out.print(" -> ");
	    		for (String s : values) {
	    			System.out.print(s);
	    		}
	    		System.out.println(" --- ");
	    }
	    StudentPair p1 = new StudentPair("1", "2");
	    StudentPair p2 = new StudentPair("2", "1");
	    Map<StudentPair,Integer> map = new HashMap<StudentPair,Integer>();
	    System.out.println(p1.equals(p2));
	  }
	  
	// TODO: Write a function that takes a list of pairs and returns a data structure containing the list of all pairs of students and their common classes
		  
	  
	  // TODO: Write a function that takes a list of pairs and returns a data structure containing the list of all pairs of students and their common classes
	  private static Map<StudentPair, List<String>> findCourses(String[][] pairs) {
		  Map<StudentPair, List<String>> result = new HashMap<>();
	    HashMap<String, Set<String>> map = getPairs(pairs);
	    Set<String> keys = getKeys(pairs);
	    List<String> arr = new ArrayList<>(keys);
	    for (int i=0; i < keys.size() - 1; i++) {
	    		for (int j=i+1; j < keys.size(); j++) {
	    			//result.put(new StudentPair(arr.get(i), arr.get(j)), new ArrayList<>());
	    		}
	    }
	    // got over vales and create the map
	    for (Map.Entry<String, Set<String>> entry: map.entrySet()) {
	      String key = entry.getKey();
	      String[] values = entry.getValue().toArray(new String[0]);
	      int length = values.length;
	      for (int i=0; i < length-1; i++) {
	    	  	for (int j=i+1; j < length; j++) {
	    	  		StudentPair pair = new StudentPair(values[i], values[j]);
	    	  		System.out.println("student pair" + values[i] + "," + values[j] + ", hashcode=" + pair.hashcode());
	    	  		List<String> subjects = result.get(pair);
	    	  		System.out.println("before " + subjects);
	    	  		if (subjects == null) subjects = new ArrayList<String>();
	    	  		subjects.add(key);
	    	  		System.out.println("after " + subjects);
	    	  		System.out.println("before add" + result.size());
	    	  		result.put(pair, subjects);
	    	  		System.out.println("after2 " + result.get(pair));
	    	  		System.out.println("after add" + result.size());
	    	  	}
	      }
	      
	    }
	    System.out.println("***");
	    System.out.println(result);
	    return result;
	  }
	  
	  private static Set<String> getKeys(String[][] pairs) {
		  	Set<String> keys = new TreeSet<>();
		  	int length = pairs.length;
		    for (int i=0; i < length; i++) {
		    		keys.add(pairs[i][0]);
		    }
		    return keys;
	  }
	  
	  // key is subject
	  private static HashMap<String, Set<String>> getPairs(String[][] pairs) {
	    HashMap<String, Set<String>> map = new HashMap<>();
	    int length = pairs.length;
	    for (int i=0; i < length; i++) {
	      Set<String> set = map.get(pairs[i][1]);
	      if (set == null) {
	        set = new TreeSet<String>();
	        set.add(pairs[i][0]);
	        map.put(pairs[i][1], set);
	      } else {
	        set.add(pairs[i][0]);
	        map.put(pairs[i][1], set);
	      }
	    }
	    System.out.println(map);
	    return map;
	  }
	  
	  
	  
	}

	// {"1,2","c1", "c2"}
		  
		  
		  

