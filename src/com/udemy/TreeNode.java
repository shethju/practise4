package com.udemy;


public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	      
	      @Override
	    public String toString() {
	    	  return ("(" + val + " l->" + left + " r->" + right + ")");
	    }
}

