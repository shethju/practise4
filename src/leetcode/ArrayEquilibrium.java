package leetcode;

// https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
public class ArrayEquilibrium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 }; 
        int arr_size = arr.length; 
        System.out.println("First equilibrium index is " +  
                          equilibrium(arr, arr_size));
	}
	
	static int equilibrium(int arr[], int n)  {
		int sum = 0;
		for (int i: arr) {
			sum = sum + i;
		}
		int leftsum = 0;
		int index = 0;
		for (int i: arr) {
			sum = sum - i;
			if (leftsum == sum) {
				return index; 
			}
			leftsum = leftsum + i;
			index++;
		}
		return -1;
	}

}
