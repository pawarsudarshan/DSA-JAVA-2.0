package DSA2.BinaryTree;
/*
Recursive approach & iterative approach
 */
public class FloorInBST {
/* Recursive approach
    public static TreeNode floor(TreeNode root, int x) {
        TreeNode[] res = new TreeNode[1];
        solve(root,x,res);
        return res[0];
    }

    public static void solve(TreeNode root, int x, TreeNode[] res){
        if(root==null) return;
        if(root.val==x) {
            res[0] = root;
            return;
        }

        if(root.val<x){
            res[0] = root;
            solve(root.right,x,res);
        }else solve(root.left,x,res);
    }
*/
/* Iterative Approach */
    public static TreeNode floor(TreeNode root, int x){
        TreeNode res = null;
        while(root!=null){
            if(root.val==x){
                return root;
            }
            else if(root.val<x){
                res = root; // potential floor
                root = root.right;
            }else root = root.left;
        }
        return res;
    }
}
