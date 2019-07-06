package leetcode.practise.interviews;



	
	import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

	class StudentCoursesCommon2 {
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
	    Map<StudentPair, Set<String>> result = findCourses(studentCoursePairs1);
	    for (Map.Entry<StudentPair, Set<String>> entry : result.entrySet()) {
	    		StudentPair key = entry.getKey();
	    		Set<String> values = entry.getValue();
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
	  private static Map<StudentPair, Set<String>> findCourses(String[][] pairs) {
		Map<StudentPair, Set<String>> result = new HashMap<>();
	    HashMap<String, Set<String>> map = getPairs(pairs);
	    List<String> listids = new ArrayList<String>(map.keySet());
	    int length = listids.size();
	    for (int i=0; i < length-1; i++) {
	    		for (int j=i+1; j < length; j++) {
	    			String id1 = listids.get(i);
	    			String id2 = listids.get(j);
	    			StudentPair p = new StudentPair(id1, id2);
	    			Set<String> subject1 = map.get(id1);
	    			Set<String> subject2 = map.get(id2);
	    			Set<String> common = new HashSet<>(subject1); // deep copy is needed
	    			common.retainAll(subject2);
	    			result.put(p, common);
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
	  
	  // key is id
	  private static HashMap<String, Set<String>> getPairs(String[][] pairs) {
		    HashMap<String, Set<String>> map = new HashMap<>();
		    int length = pairs.length;
		    for (int i=0; i < length; i++) {
		      Set<String> set = map.get(pairs[i][0]);
		      if (set == null) {
		        set = new TreeSet<String>();
		        set.add(pairs[i][1]);
		        map.put(pairs[i][0], set);
		      } else {
		        set.add(pairs[i][1]);
		        map.put(pairs[i][0], set);
		      }
		    }
		    System.out.println(map);
		    return map;
		  }

	  
	  
	  
	}

	class StudentPair {
		  String student1;
		  String student2;
		  public StudentPair(String student1, String student2) {
			  this.student1 = student1;
	    		  this.student2 = student2;
		  }
		  /*
		  public boolean equals(Object o) {
			  if (this == o) return true;
			  if (!(o instanceof StudentPair)) return false;
			  StudentPair s = (StudentPair)o;
			  if ((this.student1.equals(s.student1) && this.student2.equals(s.student2)) || 
					  (this.student1.equals(s.student2) && this.student1.equals(s.student2))) {
				  return true;
			  }
			  return false;
		  }
		  
		  public int hashcode() {
			  int result = 1;
			  result = 31 * result + ((student1 != null) ? student1.hashCode() : 0);
			  result = 31 * result + ((student2 != null) ? student2.hashCode() : 0);
			  return result;
		  }*/
	  }
		  
		  
		  
