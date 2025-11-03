package DSA2.BinaryTree;

/* Given the root of a binary tree, check whether it is a mirror of itself
(i.e., symmetric around its center) */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left,root.right);
    }
    public boolean solve(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;

        if(p!=null){
            if(q!=null){
                if(p.val==q.val){
                    return solve(p.left,q.right) && solve(p.right,q.left);
                }
            }
        }
        return false;
    }
}
