package DSA2.BinaryTree;
import java.util.*;
/*

*/
public class RootToLeafPathInBT {

    public static List<List<Integer>> allPaths = new ArrayList<>();

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
        RootToLeafPathInBT obj = new RootToLeafPathInBT();
        System.out.println(obj.allRootToLeafPaths(root));
    }

    public List<List<Integer>> allRootToLeafPaths(TreeNode root){
        List<Integer> path = new ArrayList<>();
        solve(root,path);
        return allPaths;
    }

    public void solve(TreeNode root, List<Integer> path){
        if(root==null) return; // Base case

        path.add(root.val);

        // check for leaf node
        if(root.left==null && root.right==null)
            allPaths.add(new ArrayList<>(path));

        solve(root.left, path);
        solve(root.right, path);

        path.remove(path.size()-1); // Backtracking
    }
}
