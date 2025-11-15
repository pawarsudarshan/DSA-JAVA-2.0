package DSA2.Matrices;

public class IncrementSubmatrixBy1 {
    public static void main(String[] args) {
        int n = 3;
        int[][] queries = {{1,1,2,2},{0,0,1,1}};
        int[][] res = rangeAddQueries(n,queries);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for(int i=0;i<queries.length;i++){
            int row1 = queries[i][0], col1 = queries[i][1], row2 = queries[i][2], col2 = queries[i][3];
            if(row1>row2 || col1>col2) return mat;
            for(int k=row1;k<=row2;k++){
                for(int l=col1;l<=col2;l++){
                    mat[k][l] += 1;
                }
            }
        }
        return mat;
    }
}
