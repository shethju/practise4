package array;

// https://leetcode.com/problems/maximum-subarray/
/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 * @author pj
 *
 */
public class MaxInSubArray {
	public static void main(String args[]) {
		int A[] = {-2,1,-3,4,-1,2,1,-5,4};
		maxSubArray(A);
		System.out.println("done2");
	}

	public static int maxSubArray(int[] A) {
	    int maxSoFar=A[0], maxEndingHere=A[0];
	    for (int i=1;i<A.length;++i){
	    	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
	    	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
	    }
	    return maxSoFar;
	}
}
