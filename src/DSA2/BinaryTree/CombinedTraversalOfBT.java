package DSA2.BinaryTree;
import java.util.*;

public class CombinedTraversalOfBT {
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
        System.out.println(treeTraversal(root));
    }
    public static List<List<Integer>> treeTraversal(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        solve(root,preorder,inorder,postorder);

        List<List<Integer>> finalAns = new ArrayList<>();
        finalAns.add(preorder);
        finalAns.add(inorder);
        finalAns.add(postorder);

        return finalAns;
    }
    public static void solve(TreeNode root,List<Integer> preorder, List<Integer> inorder, List<Integer> postorder){
        if(root==null) return;
        preorder.add(root.val);
        solve(root.left,preorder,inorder,postorder);
        inorder.add(root.val);
        solve(root.right,preorder,inorder,postorder);
        postorder.add(root.val);
    }
}
