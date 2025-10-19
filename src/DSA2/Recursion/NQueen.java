package DSA2.Recursion;
import java.util.*;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allConfigs = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for(int row=0;row<n;row++){
            StringBuilder sb = new StringBuilder();
            sb.append(".".repeat(n));
            board.add(sb.toString());
        }
        System.out.println(board);
        solve(board,0,n,allConfigs);
        return allConfigs;
    }

    public static void solve(List<String> board, int row, int n, List<List<String>> allConfigs){
        if(row==n){
            allConfigs.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<n;col++){
            if(isValid(board,row,col)){
                // place the queen
                char[] boardRow = board.get(row).toCharArray();
                boardRow[col] = 'Q';
                board.set(row,new String(boardRow));
                solve(board,row+1,n, allConfigs);
                boardRow[col] = '.';
                board.set(row,new String(boardRow));
                // backtrack - remove the queen
            }
        }
    }
    public static boolean isValid(List<String> board, int row, int col){
        // Check vertical column
        for(int i = 0; i < row; i++){
            if(board.get(i).charAt(col) == 'Q') return false;
        }

        // Check both upper-left and upper-right diagonals
        for(int i = 1; i <= row; i++){
            // Upper-left diagonal
            if(col - i >= 0 && board.get(row - i).charAt(col - i) == 'Q') return false;

            // Upper-right diagonal
            if(col + i < board.size() && board.get(row - i).charAt(col + i) == 'Q') return false;
        }

        return true;
    }
}
