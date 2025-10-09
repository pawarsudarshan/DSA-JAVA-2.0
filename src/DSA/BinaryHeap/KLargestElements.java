package BinaryHeap;
import java.util.*;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {2,2,5,50,1};
        int n = arr.length;
//        int k = 3;
//        ArrayList<Integer> list = kLargest(arr,n,k);
//        System.out.println(list);

        System.out.println(LargeButMinFreq(arr,n));
    }
    static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(pq.size()!=0){
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }

    static int LargeButMinFreq(int arr[], int n) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            if(m.containsKey(arr[i])){
                m.put(arr[i], m.get(arr[i])+1);
            }else{
                m.put(arr[i],1);
            }
        }

        int ans = 10000000;
        int res = 0;

        for(Map.Entry<Integer,Integer> pair : m.entrySet()){
            ans = Math.min(ans,pair.getValue());
        }

        for(Map.Entry<Integer,Integer> pair : m.entrySet()){
            if(pair.getValue()==ans)
            res = Math.max(res,pair.getKey());
        }
        return res;
    }
}
