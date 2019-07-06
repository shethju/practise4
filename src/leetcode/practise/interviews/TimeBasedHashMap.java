package leetcode.practise.interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/time-based-key-value-store
// https://leetcode.com/problems/time-based-key-value-store/discuss/226663/TreeMap-Solution-Java 
public class TimeBasedHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeMap kv = new TimeMap();   
		kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1   
		kv.get("foo", 1);  // output "bar"   
		kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"   
		kv.set("foo", "bar2", 4);   
		kv.get("foo", 4); // output "bar2"   
		kv.get("foo", 5); //output "bar2"   
	}

}

class TimeMap {

    private Map<String,TreeMap<Integer,String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key,new TreeMap<>());
        }
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> treeMap = map.get(key);
        if(treeMap==null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);
        if(floor==null) {
            return "";
        }
        return treeMap.get(floor);
    }
}
