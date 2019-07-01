package leetcode.practise.tree;

// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536
public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelp(root.left, root.right);
    }
    
    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
