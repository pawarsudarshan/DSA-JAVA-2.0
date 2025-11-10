package DSA2.BinaryTree;
import java.util.*;
/*
Approach:
Use level-order traversal to assign an index (order) to each node as if it were in a complete binary tree
=> left child = 2*i, right child = 2*i + 1
At each level, track the first (min) and last (max) node indices; the width = max - min + 1.
Keep a list or map of (level → min, max) and update them as you traverse.
 */
public class MaximumWidthOfBinaryTree {
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
        System.out.println(widthOfBinaryTree(root));
    }
    public static int widthOfBinaryTree(TreeNode root) {
        long[] res = new long[1];
        List<Pair2> list = new ArrayList<>();
        solve(root,0,1,res,list);
        return (int)res[0];
    }
    public static void solve(TreeNode root, int level, long order, long[] res,List<Pair2> list){
        if(root==null) return;

        if(list.size()<level+1){
            list.add(new Pair2(Long.MAX_VALUE,Long.MIN_VALUE));
        }

        Pair2 p = list.get(level);
        if(order<p.min) p.min = order;
        if(order>p.max) p.max = order;

        list.set(level,p);

        res[0] = Math.max(res[0],list.get(level).max-list.get(level).min+1);

        solve(root.left,level+1,order*2,res,list);
        solve(root.right,level+1,order*2+1,res,list);
    }
}

class Pair2{
    long min, max;
    Pair2(long min, long max){
        this.min = min;
        this.max = max;
    }
}