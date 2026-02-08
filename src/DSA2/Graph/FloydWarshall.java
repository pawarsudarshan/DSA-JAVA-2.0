package DSA2.Graph;

public class FloydWarshall {
    public static void main(String[] args) {

    }
    public void floydWarshall(int[][] dist) {
        int V = dist.length;
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                for(int k=0;k<V;k++){
                    if(dist[i][k] != 100000000 && dist[k][j] != 100000000 && dist[i][j] < dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }


    // Floyd Warshall Problem : City with smallest number of neighbours within threshold distance
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e9;
        int[][] dist = new int[n][n];

        // Initialization
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // Fill edges
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        // Floyd–Warshall (CORRECT ORDER)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Find answer
        int ans = -1;
        int globalMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // Important: <= ensures largest index in tie
            if (count <= globalMin) {
                globalMin = count;
                ans = i;
            }
        }

        return ans;
    }
}
