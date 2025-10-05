package BitManipulation;

import java.util.*;

public class TwoNumbersWithOddOccurrences {
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 5, 2, 3, 3, 1};
        int n = arr.length;
        int[] output = twoOddNum(arr,n);
        System.out.println(Arrays.toString(output));
    }
    public static int[] twoOddNum(int[] arr, int n)
    {
        /* code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            } else{
                hm.put(arr[i],1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer,Integer> pair : hm.entrySet()){
            if(pair.getValue()%2!=0){
                list.add(pair.getKey());
            }
        }

        Collections.sort(list);
        Collections.reverse(list);
        int[] ans = new int[2];
        ans[0] = list.get(0);
        ans[1] = list.get(1);

        return ans;

        Get one set bit in the xor2. We get rightmost set bit
        in the following line as it is easy to get :
        set_bit_no = xor2 & ~(xor2-1);

         */
        int[] ans = new int[2];

        int val = 0;
        for(int i=0;i<n;i++){
            val = val ^ arr[i];
        }

        int set_bit = val & -val;
        int grp1 = 0, grp2 = 0;

        for(int i=0;i<n;i++){
            if((set_bit & arr[i])==0){
                grp1 = grp1 ^ arr[i];
            } else{
                grp2 = grp2 ^ arr[i];
            }
        }

        if(grp1>grp2){
            ans[0] = grp1;
            ans[1] = grp2;
            return ans;
        }

        ans[0] = grp2;
        ans[1] = grp1;
        return ans;
    }
}
