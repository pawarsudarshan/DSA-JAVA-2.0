package DSA2.BinaryTree;
/* Problem statement:
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
1. The left subtree of a node contains only nodes with keys strictly less than the node's key.
2. The right subtree of a node contains only nodes with keys strictly greater than the node's key.
3. Both the left and right subtrees must also be binary search trees.

Approach: maintain two variables, min and max
while going left => root.val becomes maxvalue
while going right => root.val becomes minvalue
*/
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return verify(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean verify(TreeNode root, long min, long max){
        if(root==null) return true;

        boolean left = verify(root.left,min,root.val);
        boolean right = verify(root.right,root.val,max);

        if(left && right && (long)root.val>min && (long)root.val<max){
            return true;
        }

        return false;
    }
}
