package DSA2.BinaryTree;
import java.util.*;
/*
Solved this question very fast, boosted my confidence
Optimized approach:
Instead of computing height, add levels to finalAns as needed. See Below

public void check(TreeNode root, int level, List<List<Integer>> finalAns) {
    if (root == null) return;

    if (level == finalAns.size()) {
        finalAns.add(new ArrayList<>()); // adding levels as needed
    }

    finalAns.get(level).add(root.val);
    check(root.left, level + 1, finalAns);
    check(root.right, level + 1, finalAns);
}

*/
public class LevelOrderTraversal {
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
        System.out.println(levelOrder(root));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalAns = new ArrayList<>();
        int h = height(root);
        for(int i=0;i<h;i++){
            finalAns.add(new ArrayList<>());
        }
        solve(root,0,finalAns);
        return finalAns;
    }

    public static void solve(TreeNode root, int level, List<List<Integer>> finalAns){
        if(root==null) return;

        finalAns.get(level).add(root.val);

        solve(root.left,level+1, finalAns);
        solve(root.right,level+1, finalAns);
    }

    // Height method
    public static int height(TreeNode root){
        if(root==null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight,rightHeight);
    }
}
