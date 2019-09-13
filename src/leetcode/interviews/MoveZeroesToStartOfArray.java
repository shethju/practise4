package leetcode.interviews;

// Splunk
public class MoveZeroesToStartOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,0,2,4,0,1, 0,0,0};
		int index = nums.length -1;
		for (int i= nums.length -1; i >=0; i--) {
			if (nums[i] == 0) {
				
			} else {
				nums[index] = nums[i];
				//nums[i] = 0;
				index--;
			}
		}
		for (int j=0; j <=index; j++) {
			nums[j] = 0;
		}
		for (int i=0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
