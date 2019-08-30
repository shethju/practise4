package leetcode.practise.interviews;

public class FirstNonRepeatingCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static final int NO_OF_CHARS = 256; 
    static char count[] = new char[NO_OF_CHARS]; 
      
    /* calculate count of characters  
       in the passed string */
     static void getCharCountArray(String str)  
     { 
         for (int i = 0; i < str.length();  i++) 
              count[str.charAt(i)]++; 
     } 
       
    /* The method returns index of first non-repeating 
       character in a string. If all characters are repeating  
       then returns -1 */
    static int firstNonRepeating(String str) 
    { 
    	if (str == null || str.equals("")) return -1;
        getCharCountArray(str); 
        for (int i = 0; i < str.length();  i++) 
        { 
            if (count[str.charAt(i)] == 1) 
            { 
                return i;
            }    
        }   
        
      return -1; 
    } 

}
