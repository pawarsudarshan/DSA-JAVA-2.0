package DSA2.BinaryTree;
import java.util.*;

public class Inorder {
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

        Inorder obj = new Inorder();
        List<Integer> result = obj.inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        solve(root, inorder);
        return inorder;
    }

    private void solve(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        solve(root.left, inorder);
        inorder.add(root.val);
        solve(root.right, inorder);
    }
}
