import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(System.out::println);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int i = m - 1;
        int j = n - 1;
        for (int l = length -1; l >=0 ; l--) {
            if (i >= 0 && j >= 0) { // else arrayoutofbound
                if (nums1[i] > nums2[j]) {
                    nums1[l] = nums1[i];
                    i--;
                } else {
                    nums1[l] = nums2[j];
                    j--;
                }
            } else if (j >=0) { // when no elements in nums1
                nums1[l] = nums2[j];
                j--;
            }
        }
    }
}
