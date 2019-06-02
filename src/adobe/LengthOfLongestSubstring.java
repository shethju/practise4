package adobe;

import java.util.Arrays;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdab";
		lengthOfLongestSubstring(s);
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
