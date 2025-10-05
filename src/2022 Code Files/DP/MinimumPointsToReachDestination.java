package DP;

// check out c++ solution of the same name

public class MinimumPointsToReachDestination {
    public static void main(String[] args) {
        int[][]  arr = {{-2,-3,3},
                {-5,-10,1},
                {10,30,-5}};
        System.out.println(minPoints(arr,3,3));
    }
    static public int minPoints(int points[][],int m,int n) {
        int start = 0, end = 1000, ans = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(check(points,m,n,mid)){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return ans;
    }

    private static boolean check(int[][] points, int m, int n, int energy) {
        int [][] mat = new int[m][n];

        for(int i=0;i<m;i++){
            System.arraycopy(points[i], 0, mat[i], 0, n);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    mat[i][j] += energy;
                }else {

                    int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
                    boolean flag1 = false, flag2 = false;

                    if (i - 1 >= 0 && mat[i - 1][j] > 0) {
                        a = mat[i - 1][j];
                    }
                    if (j - 1 >= 0 && mat[i][j - 1] > 0) {
                        b = mat[i][j - 1];
                    }

                    if (i - 1 >= 0 && mat[i - 1][j] <= 0) {
                       flag1 = true;
                    }
                    if (j - 1 >= 0 && mat[i][j - 1] <= 0) {
                        flag2 = true;
                    }

                    if(flag1 && flag2) return false;

                    if (a == Integer.MIN_VALUE) a = 0;
                    if (b == Integer.MIN_VALUE) b = 0;

                    mat[i][j] += Math.max(a, b);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
        return mat[m - 1][n - 1] > 0;
    }
}
