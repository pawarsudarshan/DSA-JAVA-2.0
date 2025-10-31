package DSA2.BinaryTree;
import java.util.*;
/*

*/
public class PrintRootToLeafPathEqualToTarget {
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \   \
             7   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int targetSum = 10;
        PrintRootToLeafPathEqualToTarget obj = new PrintRootToLeafPathEqualToTarget();
        System.out.println(obj.pathSum(root,targetSum));
    }

    List<List<Integer>> allPaths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        allPaths = allRootToLeafPaths(root);
        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> path:allPaths){
            int sum = 0;
            for(int num:path) sum += num;
            if(sum==targetSum) res.add(path);
        }

        return res;
    }

    public List<List<Integer>> allRootToLeafPaths(TreeNode root){
        List<Integer> path = new ArrayList<>();
        solve(root,path);
        return allPaths;
    }

    public void solve(TreeNode root, List<Integer> path){
        if(root==null) return;

        path.add(root.val);

        // check for leaf node
        if(root.left==null && root.right==null)
            allPaths.add(new ArrayList<>(path));

        solve(root.left, path);
        solve(root.right, path);

        path.remove(path.size()-1); // Backtracking
    }
}
