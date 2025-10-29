package DSA2.Matrices;
/*
This method of checking if sudoku is valid or not is very useful in Solve Sudoku problem (Backtracking)
PS:
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
*/
public class ValidSudoku {
    // Method to check if the Sudoku is valid or not
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[10][10];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int r = i/3;
                    int c = j/3;
                    int boxNum = (r*3)+(c+1);

                    if(row[i][board[i][j]-'0']!=0 || col[j][board[i][j]-'0']!=0 || box[boxNum][board[i][j]-'0']!=0)
                        return false;

                    else{
                        row[i][board[i][j]-'0']=1;
                        col[j][board[i][j]-'0']=1;
                        box[boxNum][board[i][j]-'0']=1;
                    }
                }
            }
        }

        return true;
    }
}
