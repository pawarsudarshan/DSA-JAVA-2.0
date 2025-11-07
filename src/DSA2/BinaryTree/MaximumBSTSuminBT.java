package DSA2.BinaryTree;

public class MaximumBSTSuminBT {
    public static void main(String[] args) {

    }
}
class Solution {
    public int maxSumBST(TreeNode root) {
        int[] res = new int[1];
        solve(root,res);
        return res[0];
    }
    public Data solve(TreeNode root, int[] res){
        if(root==null) return new Data(Integer.MAX_VALUE,Integer.MIN_VALUE,0,false);

        Data left = solve(root.left,res);
        Data right = solve(root.right,res);

        if(left.isBST && right.isBST && root.val>left.max && root.val < right.min){
            int currSum = root.val + left.sum + right.sum;
            res[0] = Math.max(res[0], currSum);
            return new Data(left.min, right.max,currSum,true);
        }

        return new Data(-1,-1,-1,false);
    }
}
class Data{
    int min;
    int max;
    int sum;
    boolean isBST;
    Data(int min, int max, int sum, boolean isBST){
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.isBST = isBST;
    }
}