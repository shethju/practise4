package recursion;

class StringPermutations {

    public static void permutations(char[] array, int length) {
        if (length == 1) {
            System.out.println(array);
            return;
        }
        else {
            for (int i = 0; i < length; i++) {
                swap(array, i, length-1);
                permutations(array, length-1);
                swap(array, i, length-1);
            }
        }
    }  
    
    public static void swap(char[] array, int i, int j) {
        char c;
        c = array[i]; 
        array[i] = array[j]; 
        array[j] = c;
    }

    public static void main( String args[] ) {
        char[] input = {'a', 'b','c'};
        permutations(input, input.length);
        System.out.println("***");
        printPermutn("ab", ""); 
    }
    
    static void printPermutn(String str, String ans) 
    { 
  
        // If string is empty 
        if (str.length() == 0) { 
            System.out.print(ans + " "); 
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
  
            // Recurvise call 
            printPermutn(ros, ans + ch); 
        } 
    } 
}