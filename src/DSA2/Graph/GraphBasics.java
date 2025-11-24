package DSA2.Graph;
import java.util.*;

public class GraphBasics {
    public static void main(String[] args) {
        int[][] mat = {{1,2},{0,2},{0,1}};
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<mat.length;i++){
            graph.add(new ArrayList<>());
            for(int j=0;j<mat[i].length;j++){
                graph.get(i).add(mat[i][j]);
            }
        }
        for(List<Integer> l:graph){
            System.out.println(l);
        }
    }
}
