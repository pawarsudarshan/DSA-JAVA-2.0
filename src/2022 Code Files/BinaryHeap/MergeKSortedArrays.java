package BinaryHeap;
import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int k = 3;
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};

        ArrayList<Integer> list = mergeKArrays(arr,k);
        System.out.println(list);
    }

    static ArrayList<Integer> mergeKArrays(int[][] arr,int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for(int i=0;i<k;i++){
            pos.add(0);
        }

        for(int i=0;i<k;i++){
            pq.add(arr[i][0]);
        }

        //once again the problem is "priority queue with pair"

        return list;
    }
}
