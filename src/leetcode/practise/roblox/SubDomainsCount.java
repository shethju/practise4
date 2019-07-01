package leetcode.practise.roblox;

import java.util.*;

public class SubDomainsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"9001 discuss.leetcode.com"};
		new SubDomainsCount().subdomainVisits(str);
	}
	
	public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new LinkedList<String>();
        HashMap<String, Integer> map = getMap(cpdomains);
        for (Map.Entry<String,Integer> entry : map.entrySet())  {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;            

    }
    
    private HashMap<String, Integer> getMap(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        String delimiters = "[ ]";
        for (int i=0; i < cpdomains.length; i++) {
            String[] tokens = cpdomains[i].split(delimiters);
            Integer count = Integer.parseInt(tokens[0]);
            String tmpdomain = tokens[1];
            String[] domains = getIndividualDomains(tmpdomain);
            for (String domain : domains) {
                if (map.get(domain) == null) {
                    map.put(domain, count);
                } else {
                    Integer tmpcount = map.get(domain);
                    tmpcount = tmpcount + count;
                    map.put(domain, tmpcount);
                }
            }
        }
        return map;
    }
    
    private String[] getIndividualDomains(String domainName) {
        String delimiters = "\\.";
        String[] domains = domainName.split(delimiters);
        List<String> list = new LinkedList<>();
        for (int i = domains.length - 1, j=-1; i >=0 ; i--,j++) {
            if (j >=0) {
            list.add(domains[i] + "." + list.get(j));
            } else {
                list.add(domains[i]);
            }
        }
        String[] arr = list.toArray(new String[0]); 
        return arr;
    }

}
