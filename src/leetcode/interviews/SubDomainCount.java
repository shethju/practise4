package leetcode.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainCount {

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		String[] counts = {"900,google.com",
		         "60,mail.yahoo.com",
		         "10,mobile.sports.yahoo.com",
		         "40,sports.yahoo.com",
		         "300,yahoo.com",
		         "10,stackoverflow.com",
		         "20,overflow.com",
		         "2,en.wikipedia.org",
		         "1,m.wikipedia.org",
		         "1,mobile.sports",
		         "1,google.co.uk"};
		System.out.println("** " + subdomainVisits(counts));
		System.out.println("*** " + findCount2(counts));
	}
	
	private static HashMap<String, Integer> findCount2(String[] input) {
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    for (int i=0; i < input.length; i++) {
	      String tmp = input[i];
	      int commaIndex = tmp.indexOf(',');
	      Integer count = Integer.parseInt(tmp.substring(0, commaIndex));
	      System.out.println("*count is " + count);
	      String domain = tmp.substring(commaIndex+1);
	      System.out.println("*domain is " + domain);
	      for (int j =0; j < domain.length(); j++) {
	        if (domain.charAt(j) == '.') {
	        		map.put(domain.substring(j+1), map.getOrDefault(domain.substring(j+1),0) + count);
	        }
	      }
	        Integer mainCount = map.get(domain);
	        if (mainCount == null) {
	          map.put(domain, count);
	        } else {
	          map.put(domain, map.getOrDefault((domain),0) + count);
	        }
	    }
	    //System.out.println(map);
	    return map;
	  }
	private static HashMap<String, Integer> findCount(String[] input) {
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    for (int i=0; i < input.length; i++) {
	      String tmp = input[i];
	      int commaIndex = tmp.indexOf(',');
	      Integer count = Integer.parseInt(tmp.substring(0, commaIndex));
	      System.out.println("*count is " + count);
	      String domain = tmp.substring(commaIndex+1);
	      System.out.println("*domain is " + domain);
	      for (int j =0; j < domain.length(); j++) {
	        if (domain.charAt(j) == '.') {
	          System.out.println("substr is " + domain.substring(j+1));
	          Integer charCount = map.getOrDefault(domain.substring(j+1),0);
	          if (charCount == null) {
	            map.put(domain.substring(j+1), count);
	          } else {
	            map.put(domain.substring(j+1), charCount + count);
	          }
	        }
	      }
	        Integer mainCount = map.get(domain);
	        if (mainCount == null) {
	          map.put(domain, count);
	        } else {
	          map.put(domain, mainCount + count);
	        }
	      
	      
	    }
	    //System.out.println(map);
	    return map;
	  }

	public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        for (String cd : cpdomains) {
            int i = cd.indexOf(',');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + n);
        }

        List<String> res = new ArrayList();
        for (String d : map.keySet()) res.add(map.get(d) + " " + d);
        return res;
    }

}
