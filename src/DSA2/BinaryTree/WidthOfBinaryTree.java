package DSA2.BinaryTree;
import java.util.*;
/*

*/
public class WidthOfBinaryTree {
    public static void main(String[] args) {
        /*
                 1
                / \
               3   2
              /     \
             4       9
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        System.out.println(widthOfBinaryTree(root));
    }
    public static int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderTraversal(root,0,0,list);
        int maxWidth = 0;
        for(List<Integer> list1 : list){
            int max = Integer.MIN_VALUE, min =  Integer.MAX_VALUE;
            for(int col: list1){
                max = Math.max(max,col);
                min = Math.min(min,col);
            }
            maxWidth = Math.max(maxWidth,max-min);
        }
        return maxWidth;
    }
    public static void levelOrderTraversal(TreeNode root, int level, int line, List<List<Integer>> list) {
        if(root==null) return;

        while(list.size()<level+1){
            list.add(new ArrayList<>());
        }

        list.get(level).add(line);

        levelOrderTraversal(root.left, level+1, line-1, list);
        levelOrderTraversal(root.right, level+1, line+1,list);
    }
}
