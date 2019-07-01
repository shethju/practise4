package leetcode.practise.tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode1 root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode1> q = new LinkedList<>();
		if (root != null) {
			q.offer(root);
		}
		while (!q.isEmpty()) {
			List<Integer> subans = new LinkedList<>();
			int size = q.size();
			for (int i=0; i < size; i++) {
				TreeNode1 n = q.poll();
				subans.add(n.val);
				if (n.left != null) {
					q.offer(n.left);
				}
				if (n.right != null) {
					q.offer(n.right);
				}
			}
			ans.add(subans);
		}
		return ans;
	}
}

class TreeNode1 {
	      int val;
	      TreeNode1 left;
	      TreeNode1 right;
	      TreeNode1(int x) { val = x; }
	  }
