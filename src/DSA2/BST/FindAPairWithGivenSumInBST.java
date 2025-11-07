package DSA2.BST;
import java.util.*;
import DSA2.BinaryTree.TreeNode;

public class FindAPairWithGivenSumInBST {
    public boolean findTarget(TreeNode root, int k) {
        boolean[] res = new boolean[1];
        HashSet<Integer> s = new HashSet<>();
        solve(root,k,s,res);
        return res[0];
    }
    public void solve(TreeNode root, int k, HashSet<Integer> s, boolean[] res){
        if(root==null) return;

        if(s.contains(k-root.val)){
            res[0] = true;
            return;
        }
        s.add(root.val);

        solve(root.left,k,s,res);
        solve(root.right,k,s,res);
    }
}
