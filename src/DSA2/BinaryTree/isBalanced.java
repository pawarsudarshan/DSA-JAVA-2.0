package DSA2.BinaryTree;

/* A height-balanced binary tree is a binary tree in which
the depth of the two subtrees of every node never differs by more than one. */

public class isBalanced {
    public boolean isBalancedTree(TreeNode root) {
        int[] res = new int[1];
        res[0] = 1;
        solve(root,res);
        return res[0] == 1;
    }

    public int solve(TreeNode root, int[] res){
        if(root==null) return 0;

        int left = solve(root.left,res);
        int right = solve(root.right,res);

        if(Math.abs(left-right)>1)
            res[0] = 0;

        return 1 + Math.max(left,right);
    }
}
