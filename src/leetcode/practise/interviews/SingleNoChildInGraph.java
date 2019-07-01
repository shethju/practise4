package leetcode.practise.interviews;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SingleNoChildInGraph {
	
	public static void main(String[] args) {
	    int[][] parentChildPairs = new int[][] {
	        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
	        {4, 5}, {4, 8}, {8, 10}
	    };
	    findNodesWithZeroAndOneParents(parentChildPairs);

	  }
	  
	  
	  public static void findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
		    HashMap<Integer, Parents> map = populateMap(parentChildPairs);
		    List<Integer> singleParents = new LinkedList<Integer>();
		    Set<Integer> noParents = new HashSet<Integer>();
		    for (Map.Entry<Integer, Parents> entry: map.entrySet()) {
		      Parents p = entry.getValue();
		      if (p.parent1 != null){
		    	  	if (map.get(p.parent1) == null) {
		    	  		noParents.add(p.parent1);
		    	  	}
		      }
		      if (p.parent2 != null){
		    	  	if (map.get(p.parent2) == null) {
		    	  		noParents.add(p.parent2);
		    	  	}
		      }
		      if (p.parent2 == null && p.parent1 != null) {
		        singleParents.add(entry.getKey());
		        continue;
		      } 
		      
		    }
		    
		    System.out.println(singleParents.toString());
		    System.out.println(noParents.toString());
		  }
		  
		  private static HashMap<Integer, Parents> populateMap(int[][] pcpairs) {
		    HashMap<Integer, Parents> map = new HashMap<>();
		    int length = pcpairs.length;
		    for (int i=0; i < length; i++) {
		      Integer parent = pcpairs[i][0];
		      Integer child = pcpairs[i][1];
		      
		      if (map.get(child) == null) {
		        map.put(child, new Parents(parent, null));
		      } else {
		        Parents p = map.get(child);
		        p.parent2 = parent;
		        map.put(child,p);
		      } 
		    }
		    return map;
		  }
		  
		  
		}

		class Parents {
		    Integer parent1;
		    Integer parent2;
		    public Parents(Integer parent1, Integer parent2) {
		      this.parent1 = parent1;
		      this.parent2 = parent2;
		    }
		  }



