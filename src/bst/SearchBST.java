package bst;

public class SearchBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null && root.val != val){
            if(root.val < val){
                root = root.right;
            }
            else{
                root = root.left;
            }
            
        }
        return root;
    }

public TreeNode searchBST2_slower(TreeNode root, int val) {
    if (root == null) return root;
    if (root.val == val) return root;
    if (root.val < val) return searchBST(root.right, val);
    return searchBST(root.left, val);
}

}
