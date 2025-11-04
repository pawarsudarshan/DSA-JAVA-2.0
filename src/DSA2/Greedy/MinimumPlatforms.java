package DSA2.Greedy;
import java.util.*;
import DSA2.BinaryTree.Pair;
/*
Optimized approach:
1. Sort trains based on arrival time
2. Use minheap to track no of trains present at any time
3. If a train arrives after the earliest departure(top element of heap),
    remove that train from the heap.
4. The heap size at any moment = platforms needed.
5. Max heap size during the process = minimum platforms required.
*/
public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = {900,940,950,1100,1500,1800};
        int[] dep = {910,1200,1120,1130,1900,2000};
        System.out.println(minPlatforms(arr,dep));
    }
    /* Optimized Approach using min Heap */
    public static int minPlatforms(int[] arr, int[] dep){
        int n = arr.length;
        Pair[] trains = new Pair[n];
        for(int i=0;i<n;i++){
            trains[i] = new Pair(arr[i],dep[i]);
        }
        Arrays.sort(trains,(a,b)->{
            if(a.first!=b.first) return a.first-b.first;
            return a.second-b.second;
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        pq.add(trains[0]);
        int platforms = 0; // keeps count of minimum platforms needed

        for(int i=1;i<n;i++){
            while(!pq.isEmpty() && pq.peek().second<arr[i]){
                pq.poll();
            }
            pq.add(trains[i]);
            platforms = Math.max(platforms,pq.size());
        }
        return platforms;
    }
    /* Brute Force Approach
    => Counts number of trains present at any point in time *//*
    public static int minPlatforms(int[] arr, int[] dep){
        int[] time = new int[2401];
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=arr[i];j<=dep[i];j++){
                time[j]++;
            }
        }
        int platforms = 0;
        for(int i=1;i<=2400;i++){
            platforms = Math.max(platforms,time[i]);
        }
        return platforms;
    }*/
}
