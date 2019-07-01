package leetcode.practise.tree;

import java.util.*;

public class Traversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		preorderTraversal(root, list);
		return list;
	}
	
	private void preorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preorderTraversal(root.left, list);
		preorderTraversal(root.right, list);
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		preorderTraversal(root, list);
		return list;
	}
	
	private void inorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, list);
		list.add(root.val);
		inorderTraversal(root.right, list);
	}
	
	private void postorderTraversal(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, answer);   // traverse left subtree
        postorderTraversal(root.right, answer);  // traverse right subtree
        answer.add(root.val);                    // visit the root
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postorderTraversal(root, answer);
        return answer;
    }
}

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }