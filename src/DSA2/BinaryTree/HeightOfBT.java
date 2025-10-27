package DSA2.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HeightOfBT {
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

        System.out.println(height(root));
    }

    // Method to calculate Height of  Binary Tree
    public static int height(TreeNode root){
        if(root==null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight,rightHeight);
    }
}
