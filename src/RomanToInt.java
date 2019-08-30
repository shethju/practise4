import java.util.HashMap;
import java.util.HashSet;

public class RomanToInt {

    static HashMap<Character, Integer> map = new HashMap<>();
    static HashSet<Character> set = new HashSet<Character>();
    static HashSet<String> set2 = new HashSet<String>();
    public static void main(String[] args) {
        String s = "MMMCMXCIX";
        initMap();
        System.out.println(romanToInt(s));
    }

    static int romanToInt(String s) {
        int count = 0;
        int length = s.length();
        for (int i=0; i < length;) {
            int tmpValue = map.get(s.charAt(i));
            // look for characters in set followed by set2
            if (set.contains(s.charAt(i)) && (i+1 < length) && (set2.contains(s.substring(i, i+2)))) {
                count = count + map.get(s.charAt(i + 1)) - tmpValue;
                i = i + 2;
            } else {
                count = count + tmpValue;
                i = i + 1;
            }
        }
        return count;

    }

    private static void initMap() {
    	// general mapping of all characters
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        // set  and set2 are to be used in conjuction. We first check if character in set and then check
        // if next character is in set2, if yes then do val(i+1) - val(i) character i.e. 5-1=4 i.e. IV
        set.add('I');
        set.add('X');
        set.add('C');

        set2.add("IV");
        set2.add("IX");
        set2.add("CD");
        set2.add("CM");
        set2.add("XL");
        set2.add("XC");

    }

}
