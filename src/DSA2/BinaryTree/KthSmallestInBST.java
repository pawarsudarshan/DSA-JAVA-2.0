package DSA2.BinaryTree;

public class KthSmallestInBST {
    /* unnecessary calls can be optimized using boolean return type
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2];
        res[0] = k;
        solve(root,res);
        return res[1];
    }
    public void solve(TreeNode root, int[] res){
        if(root==null) return;

        solve(root.left,res);
        res[0]--;
        if(res[0]==0){
            res[1] = root.val;
            return;
        }
        solve(root.right,res);
    }*/
    public int kthSmallest(TreeNode root, int k){
        int[] res = new int[2];
        res[0] = k;
        solve(root,res);
        return res[1];
    }

    public boolean solve(TreeNode root, int[] res){
        if(root==null) return false;

        if(solve(root.left,res)) return true;

        if(res[0]==0) {
            res[1] = root.val;
            return true; // stop traversal
        }

        return solve(root.right,res);
    }
}
