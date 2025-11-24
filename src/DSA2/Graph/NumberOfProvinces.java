package DSA2.Graph;
import java.util.*;

public class NumberOfProvinces {
    public static void main(String[] args) {
    }
    // Solution To Number of Provinces problem on GfG platform
    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(adj,vis,i);
            }
        }
        return count;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int currNode){
        vis[currNode] = true;
        for(int j=0;j<adj.size();j++){
            if(adj.get(currNode).get(j)==1){
                if(!vis[j]){
                    dfs(adj,vis,j);
                }
            }
        }
    }
}
