package DSA2.Graph.DisjointSet;
import java.util.*;

public class NumberOfIslands2 {
    public static void main(String[] args) {

    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> ans = new ArrayList<>();
        int V = rows * cols;
        boolean[][] visited = new boolean[rows][cols];
        int[][] mat = new int[rows][cols];
        DisjointSet2 ds = new DisjointSet2(V);

        for (int[] op : operators) {
            int row = op[0], col = op[1];
            mat[row][col] = 1;
            visited[row][col] = true;
            int num = findNumber(row, col, rows, cols);

            if (col - 1 >= 0 && mat[row][col - 1] == 1) {
                int left = findNumber(row, col - 1, rows, cols);
                ds.union(num, left);
            }

            if (col + 1 < cols && mat[row][col + 1] == 1) {
                int right = findNumber(row, col + 1, rows, cols);
                ds.union(num, right);
            }

            if (row - 1 >= 0 && mat[row - 1][col] == 1) {
                int up = findNumber(row - 1, col, rows, cols);
                ds.union(num, up);
            }

            if (row + 1 < rows && mat[row + 1][col] == 1) {
                int down = findNumber(row + 1, col, rows, cols);
                ds.union(num, down);
            }

            int count = 0;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(visited[i][j] && ds.findParent(findNumber(i, j, rows, cols))==findNumber(i, j, rows, cols)){
                        count++;
                    }
                }
            }
            ans.add(count);
        }


        return ans;
    }

    public int findNumber(int row, int col, int rows, int cols){
        return row*cols + col+1;
    }
}
class DisjointSet2 {
    int[] parent;
    int[] size;

    DisjointSet2(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if (node != parent[node]) {
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }

    public void union(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);

        if (parentU == parentV) return;

        if (size[parentU] > size[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentU] = parentV;
            size[parentU] += size[parentV];
        }
    }

}

