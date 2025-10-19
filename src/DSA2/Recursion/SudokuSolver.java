package DSA2.Recursion;

public class SudokuSolver {
    public static void main(String[] args) {

    }
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    public boolean solve(char[][] board, int row, int col){
        if(col==9){
            row++;
            col = 0;
        }
        if(row==9) return true;

        if(board[row][col]!='.'){
            return solve(board,row,col+1);
        }else{
            for(int i=1;i<=9;i++){
                if(isValid(board, row, col, i)){
                    board[row][col] = (char)('0'+i);
                    if(solve(board,row,col+1)) return true;
                    else{
                        board[row][col] = '.'; // Backtracking
                    }
                }
            }
        }
        return false;
    }
    public boolean isValid(char[][] board, int row, int col, int num){
        char c = (char)('0'+num);
        for(int i=0;i<9;i++){
            if(board[row][i]==c) return false;
            if(board[i][col]==c) return false;
        }

        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;

        for(int i=rowStart;i<rowStart+3;i++){
            for(int j=colStart;j<colStart+3;j++){
                if(board[i][j]==c) return false;
            }
        }

        return true;
    }
}
