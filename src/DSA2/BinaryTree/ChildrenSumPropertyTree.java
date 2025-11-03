package DSA2.BinaryTree;
/* Given the root of Binary Tree, return true if and only if every node's
value is equal to the sum of the values stored in its left and right subtree
*/

public class ChildrenSumPropertyTree {
    public static void main(String[] args) {
         /*
                 30
                / \
               9   6
              / \   \
             4   5   6
        */
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(9);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(checkChildrenSum(root));
    }

    public static boolean checkChildrenSum(TreeNode root){
        int[] res = new int[1];
        res[0] = 1;
        solve(root,res);
        return res[0]==1;
    }

    public static int solve(TreeNode root, int[] res){
        // Base case
        if(root==null) return 0;

        // calculate the sum of left and right subtrees
        int leftSum = solve(root.left,res);
        int rightSum = solve(root.right,res);

        // check the condition for non-leaf node only
        if(root.left!=null && root.right!=null && root.val!=leftSum+rightSum){
            res[0] = 0;
        }

        // return the total sum of nodes
        return root.val + leftSum + rightSum;
    }

}
