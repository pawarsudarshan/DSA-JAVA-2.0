package DSA2.DynamicProgramming;
import DSA2.BinaryTree.TreeNode;
import java.util.*;

public class HouseRobber3 {
    /* Pure Recursive solution - intuitive
       From This solution we eliminated canRob boolean by redirecting the root to root.left.l/r & root.right.l/r
       see memoized solution for reference
     */
    public int rob(TreeNode root) {
        return solve(root, true);
    }

    public int solve(TreeNode root, boolean canRob){
        // Base case
        if(root==null) return 0;

        // Two ways
        int ans1 = 0, ans2 = 0;

        // way 1 - robbing the root
        if(canRob)
            ans1 = root.val + solve(root.left, false) + solve(root.right, false);

        // way 2 - not robbing the root
        ans2 = solve(root.left, true) + solve(root.right, true);

        return Math.max(ans1,ans2);
    }
}

/*  DP solution:

    Map<TreeNode, Integer> dp = new HashMap<>();

    public int rob(TreeNode root) {
        dp.clear();
        return solve(root);
    }

    public int solve(TreeNode node){
        // Base case
        if(node==null) return 0;

        // memoization
        if(dp.containsKey(node)) return dp.get(node);

        // robbing the node
        int rob = node.val;
        if(node.left!=null){
            rob += solve(node.left.left) + solve(node.left.right);
        }
        if(node.right!=null){
            rob += solve(node.right.left) + solve(node.right.right);
        }

        // not robbing the node
        int skip = solve(node.left) + solve(node.right);

        dp.put(node,Math.max(rob,skip)); // storing result before returning
        return dp.get(node);
    }
 */