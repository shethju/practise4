package leetcode.top100;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		twoSum(nums, target);
	}
	
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                int[] result = new int[2];
                result[0] = nums[i];
                result[1] = map.get(target - nums[i]);
                return result;
            }
           else {
                System.out.println("put:" + nums[i] + "," + i);
                map.put(nums[i],i);
            }
        }
        return new int[2];
    }
	
	public static int[] twoSumWithSorting(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length <= 1) return nums;
        int i =0;
        int j=length-1;
        for (; i <=j; ) {
        		int total = nums[i] + nums[j];
        		if (total == target) {
        			int[] result = new int[2];
        			result[0] = nums[i];
        			result[1] = nums[j];
        			return result;
        		} else {
        			if (total < target) i++;
        			if (total > target) j--;
        		}
        }
        return new int[2];
    }

}
