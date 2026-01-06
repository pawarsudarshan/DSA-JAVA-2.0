package DSA2.Graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInGraph {
    public static void main(String[] args) {
        int[][] adj = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        List<List<Integer>> graph = new ArrayList<>();

        for (int[] arr : adj) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) {
                list.add(x);
            }
            graph.add(list);
        }
    }
    public static boolean isCyclicGraph(List<List<Integer>> graph){
        return true;
    }
}
