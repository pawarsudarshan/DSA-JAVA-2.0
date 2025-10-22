package DSA2.BinaryTree;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val==val) return root;
        TreeNode left = searchBST(root.left,val);
        TreeNode right = searchBST(root.right,val);
        if(left!=null) return left;
        return right;
    }
}
