package leetcode.practise.tree;

public class IsBST {
	///// but if we pass the tree node instead of passing the value, we can avoid creating 2 long copies for each function call(because passing long is passing by copy).

    /// Also, we can avoid even using long by doing that.
	public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val)) return false; // equal to needed
        return helper(root.left, min, root) && helper(root.right, root, max);
    }
    /////
	
	///////////
	public boolean isValidBST4(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
    
    public boolean isValidBST3(TreeNode root) {        
        return helper2(root, null, null);   
    }
    
    private boolean helper2(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) 
            return true;
        if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val))
            return false;

        return helper2(root.left, min, root) && helper2(root.right, root, max);
    }
    
    ///////////
    private boolean help2(TreeNode p, Integer minVal, Integer maxVal) {
        if (p == null) return true;
        if ((minVal == null || p.val < minVal) || (maxVal == null || p.val > maxVal)) return false;
        return help2(p.left, minVal, p.val) && help2(p.right, p.val, maxVal);
        //return (low == null || p.val > low) && (high == null || p.val < high) && help(p.left, low, p.val) && help(p.right, p.val, high);
    }
    
    ///////////
    private boolean help(TreeNode p, Integer low, Integer high) {
        if (p == null) return true;
        return (low == null || p.val > low) && (high == null || p.val < high) && help(p.left, low, p.val) && help(p.right, p.val, high);
    }

    public boolean isValidBST2(TreeNode root) {
        return help(root, null, null);
    }
    
    ///////////
}
