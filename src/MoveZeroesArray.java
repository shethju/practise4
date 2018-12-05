import java.util.Arrays;

public class MoveZeroesArray {
    public static void main(String[] args) {
        int[] nums = {0,2,2,0,1,2};
        moveZeroes2(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    static void moveZeroes(int[] nums) {
        int index0 = Integer.MIN_VALUE;
        int indexNonZero = Integer.MIN_VALUE;
        for (int i=0; i < nums.length; ) {
            if (nums[i] == 0)
            {
                index0 = i;
                for (int j = i+1; j < nums.length; j++)
                {
                    if (nums[j] != 0)
                    {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
            i++;
        }
    }

    static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
