package DSA2.BinaryTree;
/* Problem statement:
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
1. The left subtree of a node contains only nodes with keys strictly less than the node's key.
2. The right subtree of a node contains only nodes with keys strictly greater than the node's key.
3. Both the left and right subtrees must also be binary search trees.
*/
public class ValidateBST {
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \   \
             4   5   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

    }
//    public static boolean isValidBST(TreeNode root) {
//        return solve(root);
//    }
//
//    public static int solve(TreeNode root){
//        solve(root.left);
//        solve(root.right);
//    }
}
