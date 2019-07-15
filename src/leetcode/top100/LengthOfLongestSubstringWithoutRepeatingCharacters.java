package leetcode.top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstringWithoutRepeatingCharacters {
 //https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812/Share-my-Java-solution-using-HashSet
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		//lengthOfLongestSubstringIdealSolution(s);
		System.out.println(lengthOfLongestSubstringMySET(s));
		//System.out.println(lengthOfLongestSubstringLCSET(s));
	}
	
	public static int lengthOfLongestSubstringLCSET(String s) {
	    int i = 0, j = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    
	    while (j < s.length()) {
	        if (!set.contains(s.charAt(j))) {
	            set.add(s.charAt(j++)); // Note incrementing j over here only
	            max = Math.max(max, set.size());
	        } else {
	            set.remove(s.charAt(i++)); // Note NOT incrementing j
	        }
	    }
	    
	    return max;
	}
	
	public static int lengthOfLongestSubstringMySET(String s) {
		HashSet<Character> set = new HashSet<>();
		int i = 0; // left index
		int j = 0; // iterator
		int length = s.length();
		int max = 0;
		for (; j < length; ) { //// Note NOT incrementing j
			if (set.contains(s.charAt(j))) {
				while (i <= j && set.contains(s.charAt(j))) {
					set.remove(s.charAt(i));
					i++;
				}
			} else {
				set.add(s.charAt(j));
				max = Math.max(max, set.size());
				j++; // Note incrementing j over here only
				
			}
		}
		return max;
	}

	// https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/ (Approach 3)
	/*
	 * HashMap solution
	 */
	public static int lengthOfLongestSubstringIdealSolution(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0; // left/slow index
        int j = 0; // right/actual traversal index
        int max = 0;
        for ( ; j < s.length(); j++) {
        		if (map.containsKey(s.charAt(j))) {
        			i = Math.max(map.get(s.charAt(j)), i); // "adbccba", since our map still has the older mapping when we hit the 2nd b, if we dont have max map.get
        			// will get index of 1st b thus resetting our window
        		}
        		max = Math.max(j - i + 1, max);
        		map.put(s.charAt(j), j+1); // key = character, value = current index+1 since when we get it we want the next index directly
        }
        return max;
    }
	
	public static int lengthOfLongestSubstring(String s) {
        int[] idx = new int[256];
        Arrays.fill(idx, -1);
        int max = 0;
        for (int i = 0, from = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] >= from) // Since we never clear idx after init, must >= from for validity
                from = idx[s.charAt(i)] + 1;
            idx[s.charAt(i)] = i;
            max = Math.max(max, i - from + 1);
        }
        return max;
    }
}
/*
public void add(K key,V value)
{
	
	int index=getBucketIndex(key);
	System.out.println(index);
	HashNode<K, V>head=bucket.get(index);
	HashNode<K, V>toAdd=new HashNode<>();
	toAdd.key=key;
	toAdd.value=value;
	if(head==null)
	{
		bucket.set(index, toAdd);
		size++;
		
	}
	else
	{
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				head.value=value;
				size++;
				break;
			}
			head=head.next;
		}
		if(head==null)
		{
		head=bucket.get(index);
		toAdd.next=head;
		bucket.set(index, toAdd);
		size++;
		}
	}
	if((1.0*size)/numBuckets>0.7)
	{
		//do something
		ArrayList<HashNode<K, V>>tmp=bucket;
		bucket=new ArrayList<>();
		numBuckets=2*numBuckets;
		for(int i=0;i<numBuckets;i++)
		{
			bucket.add(null);
		}
		for(HashNode<K, V> headNode:tmp)
		{
			while(headNode!=null)
			{
				add(headNode.key, headNode.value);
				headNode=headNode.next;
			}
		}
		
		
	}
	
}
*/