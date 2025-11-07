package DSA2.BinaryTree;

public class MaximumPathSumInBT {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        solve(root,res);
        return res[0];
    }
    public int solve(TreeNode root, int[] res){
        if(root==null) return 0;

        int left = Math.max(0,solve(root.left, res)); // count only positive gains
        int right = Math.max(0,solve(root.right, res));

        int currMax = root.val + left + right;
        res[0] = Math.max(res[0],currMax);

        return root.val + Math.max(left,right);
    }
}
