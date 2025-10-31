package DSA2.BinaryTree;

public class RootToLeafSumEqualToTarget {
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

        int targetSum = 10;
        System.out.println(hasPathSum(root,targetSum));
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        int[] res = new int[1];
        solve(root,targetSum,0,res);
        return res[0] != 0;
    }

    public static void solve(TreeNode root, int targetSum, int sum, int[] res){
        if(root==null) return; // this base case can be omitted by adding the same bc in parent method

        sum += root.val;

        // check for pathSum == target => this works as the base case as well
        if(root.left==null && root.right==null){
            if(sum==targetSum) res[0] = 1;
            return;
        }

        if(root.left!=null)
            solve(root.left,targetSum,sum,res);

        if(root.right!=null)
            solve(root.right,targetSum,sum,res);

        sum -= root.val;
    }
    /*
    Clean code solution:
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
     */


}
