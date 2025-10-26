package DSA2.Greedy;
import java.util.*;

class Pair{
    double first;
    double second;
    public Pair(double first, double second){
        this.first = first;
        this.second = second;
    }
}

/*
Need to get  hands dirty on Java the language
1. How to create a custom Pair class
2. Create array/lists based on custom data types
3. How to sort lists based on custom criterion
 */
public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] wt = {10,20,30};
        int[] val = {60,100,120};
        int capacity = 50;
        System.out.println(fractionalKnapsack(val,wt,capacity));
    }
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        List<Pair> list = new ArrayList<>();
        int n = wt.length;

        for(int i=0;i<n;i++){
            double wti = (double)wt[i];
            double vali = (double) val[i];
            list.add(new Pair(vali,wti));
        }

        list.sort((a, b) -> Double.compare(b.first / b.second, a.first / a.second));

        double ans = 0;
        int i=0;
        while(capacity>0 && i<n){
            double value = list.get(i).first;
            double weight = list.get(i).second;
            if(weight<capacity){
                ans += value;
                capacity -= weight;
            } else{
                ans += capacity/weight*value;
                capacity = 0;
            }
            i++;
        }
        return ans;
    }
}