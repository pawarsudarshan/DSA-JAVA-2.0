package DSA2.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplications {
    public static void main(String[] args) {
        int start = 3;
        int end = 30;
        int[] arr = {2,5,7};
        System.out.println(minimumMultiplications(arr,start,end));
    }
    public static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Tuple2> q = new LinkedList<>();
        q.add(new Tuple2(1, start, start));
        int count = 0;
        while(!q.isEmpty()){
            count ++;
            if(count>10001) return -1;
            Tuple2 t = q.poll();
            int currentNumber = t.node;
            int currentProduct = t.cost;
            int steps = t.stops;
            long product = (long) currentProduct;

            for(int i=0;i<arr.length;i++){
                product *= arr[i];
                product %= 100000;

                System.out.println(product);

                if(product == end){
                    return steps;
                }

                q.add(new Tuple2(steps+1,(int)product,(int)product));
                product = (long) currentProduct;
            }

        }

        return -1;
    }
}
