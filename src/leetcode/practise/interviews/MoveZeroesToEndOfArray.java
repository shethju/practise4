package leetcode.practise.interviews;

// Splunk
public class MoveZeroesToEndOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,0,2,4,0,1, 0,0,0};
		int index = 0;
		for (int i= 0; i <= nums.length -1; i++) {
			if (nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			} else {
			}
		}
		for (int j=index; j <nums.length; j++) {
			nums[j] = 0;
		}
		for (int i=0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
