package DSA2.BinaryTree;
import java.util.*;

public class Postorder {
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

        Postorder obj = new Postorder();
        System.out.println(obj.postorderTraversal(root));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        solve(root,postorder);
        return postorder;
    }
    public void solve(TreeNode root, List<Integer> postorder){
        if(root==null) return;
        solve(root.left,postorder);
        solve(root.right,postorder);
        postorder.add(root.val);
    }
}
