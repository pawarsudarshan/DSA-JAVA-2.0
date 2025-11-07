package DSA2.BinaryTree;
/* Given the root of Binary Tree, return true if and only if every node's
value is equal to the sum of the values stored in its left and right child nodes
*/

public class ChildrenSumPropertyTree {
    public static void main(String[] args) {
         /*
                 30
                / \
               12   18
              / \   \
             4   8   18
        */
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(12);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(18);
        System.out.println(checkChildrenSum(root));
    }

    public static boolean checkChildrenSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = 1;
        solve(root, res);
        return res[0] == 1;
    }

    public static int solve(TreeNode root, int[] res) {
        if (root == null) return 0;
        if (res[0] == 0) return 0; // early exit

        int leftVal = solve(root.left, res);
        int rightVal = solve(root.right, res);

        // check for non-leaf nodes because
        // leaf nodes already satisfy the criteria for children sum
        if (root.left != null || root.right != null) {
            if (root.val != leftVal + rightVal) {
                res[0] = 0;
            }
        }

        return root.val;
    }

}
