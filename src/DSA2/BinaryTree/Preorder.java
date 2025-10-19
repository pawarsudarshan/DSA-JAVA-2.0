package DSA2.BinaryTree;
import java.util.*;

public class Preorder {
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

        Preorder obj = new Preorder();
        System.out.println(obj.preorderTraversal(root));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        solve(root,preorder);
        return preorder;
    }
    public void solve(TreeNode root, List<Integer> preorder){
        if(root==null) return;
        preorder.add(root.val);
        solve(root.left, preorder);
        solve(root.right,preorder);
    }
}
