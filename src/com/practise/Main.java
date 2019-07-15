package com.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer i = new Integer(10);
        Integer i1 = new Integer(20);
        i1.compareTo(i);
        HashMap<Integer, List<String>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        System.out.println(map.get(1).size());
        List<String> s = map.get(1);
        System.out.println(s.size());
        s.add("abc");
        map.put(1,s);
        System.out.println(map.get(1).size());
    }
}
