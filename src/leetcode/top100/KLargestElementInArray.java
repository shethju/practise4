package leetcode.top100;

import java.util.PriorityQueue;

// Solution: https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem 
// 
public class KLargestElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i= {3,2,1,5,6,4};
		
	}
	
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : nums)
        {
            pq.add(num);
            if(pq.size()>k)
                pq.poll();
        }   
        return pq.poll();
    }

}
