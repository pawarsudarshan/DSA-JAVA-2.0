package Matrix;
import javax.crypto.spec.PSource;
import java.util.*;

public class BooleanMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0},
                          {0, 0}};
        int R = 2, C = 2;

        booleanMatrix(matrix);

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void booleanMatrix(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();


        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(matrix[i][j]==1){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int val:row){
            setRow(matrix,R,C,val);
        }
        for(int val:col){
            setCol(matrix,R,C,val);
        }
    }
    private static void setRow(int[][] matrix, int R, int C, int val) {
        for(int j=0;j<C;j++){
            matrix[val][j] = 1;
        }
    }
    private static void setCol(int[][] matrix, int R, int C, int val) {
        for(int i=0;i<R;i++){
            matrix[i][val] = 1;
        }
    }

}
