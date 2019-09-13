package com.udemy;

/*
 * Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
   
   Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree) 
   
   Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.
 */
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
	
	public TreeNode lookup(int value) {
		TreeNode tmp = root;
		while (tmp != null) {
			if (tmp.val == value) return tmp;
			if (value < tmp.val) tmp = tmp.left;
			else tmp = tmp.right;
		}
		return null;
	}
	
	public void printTree() {
		traversePreOrder(root);
	}
	
	public void traversePreOrder(TreeNode node) {
		if (node == null) return;
		System.out.println(node);
		traversePreOrder(node.left);
		traversePreOrder(node.right);
	}
}
