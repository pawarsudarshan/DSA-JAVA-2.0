package RandomDSAQuestions2;
import java.util.*;
// solve this once again

public class ThreeDivisors {
    public static void main(String[] args) {
        ArrayList<Long> query = new ArrayList<>();
        query.add(6L);
        query.add(10L);
        ArrayList<Integer> list = threeDivisors(query,query.size());
//        System.out.println(list);
    }

    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        ArrayList<Integer> list = build(100000);
        ArrayList<Integer> list2 = new ArrayList<>();
        int ans = 0;

        for(int i=0;i<q;i++) {
            int start = 0, end = list.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (list.get(mid) <= query.get(i)){
                    ans = mid;
                    start = mid+1;
                }
                else end = mid-1;

            }

            System.out.println(ans);
            list2.add(ans);
        }

        return list2;
    }
    static ArrayList<Integer> build(int n){
        ArrayList<Integer> list = new ArrayList<>();
        int[] prime = new int[n+1];
        Arrays.fill(prime,1);
        prime[0] = 0;
        prime[1] = 0;

        for(int i=2;i*i<=n;i++){
            if(prime[i]==1){
                for(int j=i+i;j<=n;j+=i){
                    prime[j] = 0;
                }
            }
        }

        for(int i=2;i<=n;i++){
            if(prime[i]==1) list.add(i);
        }

//        System.out.println(list);
        return list;
    }
}
