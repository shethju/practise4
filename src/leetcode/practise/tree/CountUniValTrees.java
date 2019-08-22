package leetcode.practise.tree;

// https://leetcode.com/articles/count-univalue-subtrees/
/**
 * 
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.
Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
 *
 */
public class CountUniValTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		countUnivalSubtrees(root);
	}
	
	private static  int res;
    public static int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    private static boolean helper(TreeNode node){
        if(node == null){
            return true; // note returns
        }
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        if(left && right){
            if ((node.left != null && node.val != node.left.val) ||
                (node.right != null && node.val != node.right.val)){
                    return false; // note returns
            }
            res++;
            return true; // if values are equal return true. note returns
        }
        return false; // if left or right is false, return false. note returns
    }

}
