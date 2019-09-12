package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// https://stackoverflow.com/questions/16748030/difference-between-arrays-aslistarray-and-new-arraylistintegerarrays-aslist
/*
 * First, let's see what this does:

Arrays.asList(ia)
It takes an array ia and creates a wrapper that implements List<Integer>, which makes the original array available as a list. 
Nothing is copied and all, only a single wrapper object is created. Operations on the list wrapper are propagated to the original array. 
This means that if you shuffle the list wrapper, the original array is shuffled as well, if you overwrite an element, it gets overwritten 
in the original array, etc. Of course, some List operations aren't allowed on the wrapper, like adding or removing elements from the list, 
you can only read or overwrite the elements.

Note that the list wrapper doesn't extend ArrayList - it's a different kind of object. ArrayLists have their own, internal array, 
in which they store their elements, and are able to resize the internal arrays etc. The wrapper doesn't have its own internal array, 
it only propagates operations to the array given to it.

On the other hand, if you subsequently create a new array as

new ArrayList<Integer>(Arrays.asList(ia))
then you create new ArrayList, which is a full, independent copy of the original one. Although here you create the wrapper using Arrays.asList 
as well, it is used only during the construction of the new ArrayList and is garbage-collected afterwards. The structure of this new ArrayList 
is completely independent of the original array. It contains the same elements (both the original array and this new ArrayList reference 
the same integers in memory), but it creates a new, internal array, that holds the references. So when you shuffle it, add, remove elements etc., 
the original array is unchanged.
 */
public class ArrayBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                           // v1 == null
        // 2. cast an array to a vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<Integer>(Arrays.asList(a));
        Integer[] arr = v1.toArray(new Integer[0]); 
        
        for (Integer x : arr) 
            System.out.print(x + " "); 
	}

}
