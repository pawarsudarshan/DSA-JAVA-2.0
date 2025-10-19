package DSA2.BinaryTree;
import java.util.*;
/*

 */

public class VerticalOrderTraversal {
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

        VerticalOrderTraversal obj = new VerticalOrderTraversal();
        System.out.println(obj.verticalTraversal(root));
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        solve(root,0,0,map);
        List<List<Integer>> res = new ArrayList<>();
        int amplitude = map.size();
        for(int i=(-amplitude);i<=amplitude;i++ ){
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(i)){
                List<Pair> temp = map.get(i);
                temp.sort((a, b) -> {
                    if (a.first == b.first)
                        return a.second - b.second;
                    return a.first - b.first;
                });
                for(Pair pair : temp){
                    list.add(pair.second);
                }
                res.add(list);
            }
        }
        return res;
    }

    public void solve(TreeNode root, int row, int col, HashMap<Integer, List<Pair>> map){
        if(root==null) return;
        if(map.containsKey(col)){
            map.get(col).add(new Pair(row,root.val));
        }else{
            map.put(col, new ArrayList<>());
            map.get(col).add(new Pair(row,root.val));
        }
        solve(root.left, row+1,col-1, map);
        solve(root.right, row+1,col+1, map);
    }
}
