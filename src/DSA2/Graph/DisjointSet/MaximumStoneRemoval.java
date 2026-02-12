package DSA2.Graph.DisjointSet;
import java.util.*;

public class MaximumStoneRemoval {
    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
//        int[][] stones = {{7,31},{9,48},{8,34}};
        System.out.println(maxRemove(stones));
    }
    public static int maxRemove(int[][] stones) {
        int m = 0, n = 0;
        for(int i=0;i<stones.length;i++){
            int row = stones[i][0], col = stones[i][1];
            m = Math.max(m,row);
            n = Math.max(n,col);
        }
        DisjointSet2 ds = new DisjointSet2(m+n+1);
        Set<Integer> set = new HashSet<>();

        for(int[] stone: stones){
            int row = stone[0];
            int col = stone[1] + m + 1;
            ds.union(row,col);
            set.add(row);
            set.add(col);
        }

        int count = 0;
        for(int ele:set){
            if(ds.findParent(ele)==ele) count++;
        }
        return stones.length - count;
    }
}
