package RandomDSAQuestions;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] costs = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;
        System.out.println(totalCost(costs,k,candidates));
    }
    static public long totalCost(int[] costs, int k, int candidates) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = costs.length;
        for (int cost : costs) list.add(cost);

        long hiringCost = 0;

        for(int j=0;j<k;j++){
            int len = list.size();
            int minEle = Integer.MAX_VALUE;
            int idx = -1;

            for(int i=0;i<Math.min(candidates,len);i++){
                if(minEle>list.get(i)){
                    minEle = list.get(i);
                    idx = i;
                }
                else if(minEle==list.get(i)){
                    idx = Math.min(idx,i);
                }
            }
            for(int i=len-1;i>=Math.max(0,len-candidates);i--){
                if(minEle>list.get(i)){
                    minEle = list.get(i);
                    idx = i;
                }
                else if(minEle==list.get(i)){
                    idx = Math.min(idx,i);
                }
            }
            System.out.println("We have hired "+minEle);
            hiringCost+=minEle;
            list.remove(idx);
        }

        return hiringCost;
    }

}
