package DSA2.BST;
import DSA2.BinaryTree.TreeNode;

public class KthLargestInBST {
    public static int kthLargest(TreeNode root, int k){
        int[] res = new int[2];
        res[0] = k;
        solve(root,res);
        return res[1];
    }
    public static boolean solve(TreeNode root, int[] res){
        if(root==null) return false;

        if(solve(root.left,res)) return true;

        if(--res[0]==0){
            res[1] = root.val;
            return true; // stop traversal
        }

        return solve(root.right,res);
    }
}
