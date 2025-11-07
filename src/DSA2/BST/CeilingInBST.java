package DSA2.BST;
import DSA2.BinaryTree.TreeNode;

public class CeilingInBST {
    public static TreeNode findCeilInBST(TreeNode root, int target){
        TreeNode res = null;
        while(root!=null){
            if(root.val==target) return root;
            if(root.val>target){
                res = root; // potential ceiling
                root = root.left;
            }
            else root  = root.right;
        }
        return res;
    }
}
