package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                           // v1 == null
        // 2. cast an array to a vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<Integer>(Arrays.asList(a));
	}

}
