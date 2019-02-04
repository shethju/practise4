package com.udemy;

public class BinaryTree {
	TreeNode root;
	
	public void add(int value) {
		TreeNode n = new TreeNode(value);
		if (root == null) {
			root = n;
			return;
		} else {
			TreeNode temp = root;
			while (true) {
				if (value < temp.val) {
					if (temp.left == null) {
						temp.left = n;
						return;
					}
					temp = temp.left;
				} else {
					if (temp.right == null) {
						temp.right = n;
						return;
					} 
					temp = temp.right;
				}
			}
		}
		
	}
	
	public void printTree() {
		traversePreOrder(root);
	}
	
	public void traversePreOrder(TreeNode node) {
		if (node == null) return;
		System.out.println(node.val);
		traversePreOrder(node.left);
		traversePreOrder(node.right);
	}
}
