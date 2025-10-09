public class SetMatrixZeroes {
    public static void main(String[] args) {
        // test cases code
    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean doesFirstRowContainsZero = false;
        boolean doesFirstColContainsZero = false;

        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) {
                doesFirstRowContainsZero = true;
                break;
            }
        }

        for(int j=0;j<n;j++){
            if(matrix[0][j]==0) {
                doesFirstColContainsZero = true;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }

        for(int j=1;j<n;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<m;i++){
                    matrix[i][j]=0;
                }
            }
        }

        if(doesFirstRowContainsZero){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }}

        if(doesFirstColContainsZero){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }}
    }
}
