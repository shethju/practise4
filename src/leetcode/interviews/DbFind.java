package leetcode.interviews;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<HashMap<String,Integer>> table = new ArrayList<HashMap<String,Integer>>();
		HashMap<String,Integer> entry1 = new HashMap<String,Integer>();
		entry1.put("a",1);
		entry1.put("b",0);
		entry1.put("c",0);
		entry1.put("d",0);
		table.add(entry1);
		HashMap<String,Integer> entry2 = new HashMap<String,Integer>();
		entry2.put("a",0);
		entry2.put("b",2);
		entry2.put("c",3);
		entry2.put("d",-1);
		table.add(entry2);
		HashMap<String,Integer> entry3 = new HashMap<String,Integer>();
		entry3.put("a",0);
		entry3.put("b",0);
		entry3.put("c",0);
		//entry3.put("d",4);
		table.add(entry3);
		table = new ArrayList<HashMap<String,Integer>>();
		HashMap<String, Integer> result = minByColumn(table, "d");
		System.out.println(result);
		
	}
	
	private static HashMap<String,Integer> minByColumn(List<HashMap<String,Integer>> table, String column) {
		if (table == null || table.size() == 0) return null;
		HashMap<String, Integer> result = table.get(0);
		if (result.get(column) == null) return result;
		int minimum = result.get(column);
		int index = 0;
		for (int i=1; i < table.size(); i++) {
			HashMap<String, Integer> temp = table.get(i);
			Integer tmpValue = temp.get(column);
			if (tmpValue != null && tmpValue < minimum) {
				minimum = tmpValue;
				index = i;
			}
		}
		return table.get(index);
	}

}
