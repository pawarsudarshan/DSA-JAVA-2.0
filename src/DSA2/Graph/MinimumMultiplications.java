package DSA2.Graph;
import java.util.*;

public class MinimumMultiplications {
    public static void main(String[] args) {
        int start = 3;
        int end = 30;
        int[] arr = {2,5,7};
        System.out.println(minimumMultiplications(arr,start,end));
    }

    public static int minimumMultiplications(int[] arr, int start, int end){
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(start);

        while (!q.isEmpty()) {
            level++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int curr = q.poll();
                for (int j = 0; j < arr.length; j++) {
                    long product = (long) ((long) curr * (long) arr[j]);
                    product %= 100000;
                    int newProduct = (int) product;
                    if (!set.contains(newProduct)) {
                        set.add(newProduct);
                        q.add(newProduct);
                        if (newProduct == end) {
                            return level;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
