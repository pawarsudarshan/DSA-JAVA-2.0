package DSA2.Matrices;

public class EqualSumGridPartition {
    public static void main(String[] args) {
        int[][] grid = {{14742, 71685, 59237, 27190}};
        System.out.println(canPartitionGrid(grid));
    }

    public static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long sum = 0;
        long[] rowSum = new long[m];
        long[] colSum = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
                System.out.println(sum);
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }

        if (sum % 2 != 0) return false;
        long halfSum = sum / 2, rowContinuousSum = 0, colContinuousSum = 0;

        for (int i = 0; i < m; i++) {
            rowContinuousSum += rowSum[i];
            if (rowContinuousSum == halfSum) {
                return true;
            }
        }

        for (int i = 0; i < n; i++) {
            colContinuousSum += colSum[i];
            if (colContinuousSum == halfSum) {
                return true;
            }
        }

        return false;
    }
}
