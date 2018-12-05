import java.util.Arrays;
import java.util.HashMap;

public class SumOf2NumEquals1 {

    public static void main(String args[]) {
        int[] nums = new int[]{2, 8, 11, 15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);

        System.out.println("hello");
    }

    public static int[] twoSum(int[] num, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < num.length; i++) {
            if (map.containsKey(target - num[i])) {
                result[1] = i;
                result[0] = map.get(target - num[i]);
                return result;
            } else {
                map.put(num[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
