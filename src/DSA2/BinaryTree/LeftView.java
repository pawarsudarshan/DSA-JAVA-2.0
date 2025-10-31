package DSA2.BinaryTree;
import java.util.*;
/*
Add the first element at every level while traversing the tree
 */
public class LeftView {
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

        System.out.println(leftView(root));
    }

    public static ArrayList<Integer> leftView(TreeNode root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        solve(root,0,list);
        return list;
    }

    public static void solve(TreeNode root, int level, ArrayList<Integer> list) {
        if(root == null) return;

        while(list.size()<level+1){
            list.add(root.val);
        }

        solve(root.left, level+1, list);
        solve(root.right, level+1, list);
    }

}
