package DSA2.BinaryTree;

public class LCAInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;

        if(root.val<p.val && root.val<q.val){ // if both p & q are greater, search in right subtree
            return lowestCommonAncestor(root.right,p,q);
        }
        else if(root.val>p.val && root.val>q.val){ // if both p & q are smaller, search in left subtree
            return lowestCommonAncestor(root.left,p,q);
        }
        else return root; // one exist in left and other in right, i.e. root is LCA
    }
}
