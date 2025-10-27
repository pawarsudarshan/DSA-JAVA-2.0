package DSA2.BinaryTree;
import java.util.*;
/*
Tip: Calculate Diameter and return height
 */
public class DiameterOfBT {
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
        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        solve(root,list);
        return list.get(0);
    }

    // Method to calculate Diameter of Binary Tree
    public static int solve(TreeNode root,List<Integer> list){
        if(root==null) return 0;

        int l = solve(root.left,list);
        int r = solve(root.right,list);

        int mx = l+r;
        if(mx>list.get(0)) list.set(0,mx);

        return 1 + Math.max(l,r);
    }
}
