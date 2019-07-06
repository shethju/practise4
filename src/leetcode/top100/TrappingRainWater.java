package leetcode.top100;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {0,1,0,2,1,0,1,3,2,1,2,1};
		trap(values);
	}

	public static int trap(int[] height) {
		int totalamount = 0;
	    int length = height.length;
	    int lefthighest[] = new int[length+1];
	    lefthighest[0] = 0;
	    for (int i=0; i < length; i++) {
	    		lefthighest[i+1] = Math.max(lefthighest[i], height[i]);
	    }
	    int rightHighest = 0;
	    for (int i=length-1; i >=0; i--) {
	    		rightHighest = Math.max(rightHighest, height[i]);
	    		totalamount += Math.min(rightHighest, lefthighest[i]) - height[i] > 0 ? Math.min(rightHighest, lefthighest[i]) - height[i] : 0;
	    }
	    return totalamount;
	}
}
