package DSA2.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BottomViewOfBT {
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
        System.out.println(bottomViewOfBT(root));
    }
    public static List<Integer> bottomViewOfBT(TreeNode root){
        List<Pair> posCol = new ArrayList<>();
        List<Pair> negCol = new ArrayList<>();

        solve(root,0,0,posCol,negCol);

        List<Integer> topView = new ArrayList<>();
        for(int i=negCol.size()-1;i>=0;i--){
            topView.add(negCol.get(i).second);
        }
        for(Pair p:posCol){
            topView.add(p.second);
        }

        return topView;
    }

    public static void solve(TreeNode root, int level, int col, List<Pair> posCol, List<Pair> negCol){
        if(root==null) return;

        if(col>=0){
            while(posCol.size()<col+1){
                posCol.add(new Pair(level,root.val));
            }
            if(posCol.get(col).first<level){
                posCol.get(col).first = level;
                posCol.get(col).second = root.val;
            }
        } else{
            int newCol = (-1)*col;
            while(negCol.size()<newCol){
                negCol.add(new Pair(level,root.val));
            }
            if(negCol.get(newCol-1).first<level){
                negCol.get(newCol-1).first = level;
                negCol.get(newCol-1).second = root.val;
            }
        }

        solve(root.left,level+1,col-1, posCol, negCol);
        solve(root.right,level+1,col+1, posCol, negCol);
    }
}