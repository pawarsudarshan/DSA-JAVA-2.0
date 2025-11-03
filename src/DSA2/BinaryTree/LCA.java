package DSA2.BinaryTree;
import java.util.*;
/*

*/

public class LCA {
    /* Below is my approach, also handles the case if LCA does not exist */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> lca = new ArrayList<>();
        solve(root,p,q,lca);

        if(!lca.isEmpty())
            return lca.get(0);

        return null;
    }
    public boolean solve(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> lca){
        if(root==null) return false;

        if(root==p || root==q){

            boolean left = solve(root.left, p, q, lca);
            boolean right = solve(root.right,p, q, lca);

            if(left||right){
                lca.add(root);
                return false;
            }

            return true;
        }

        boolean left = solve(root.left, p, q, lca);
        boolean right = solve(root.right,p, q, lca);

        if(left && right){
            lca.add(root);
            return false;
        }

        return left||right;
    }
/*  Leetcode solution variant when it is guaranteed that LCA exists
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left !=null && right != null) {
            return root;
        }

        return (left == null)? right: left;
    }
*/
}
