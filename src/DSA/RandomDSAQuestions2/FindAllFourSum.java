package RandomDSAQuestions2;
import java.util.*;

public class FindAllFourSum {
    public static void main(String[] args) {
        int[] arr = {10,2,3,4,5,7,8};
        int target = 23;
        ArrayList<ArrayList<Integer>> list = fourSum(arr,target);
        System.out.println(list);
    }
    static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        Set<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);

        for(int i=0;i<=n-4;i++){
            for(int j=i+1;j<=n-3;j++){
                int sum = arr[i] + arr[j];
                int diff = target - sum;
                int start = j+1, end = n-1;

                while(start<end){
                    if(arr[start]+arr[end]==diff){
                        helper(arr[i],arr[j],arr[start],arr[end],hs,list);
                        start++;
                        end--;
                    }
                    else if(arr[start]+arr[end]>diff){
                        end--;
                    } else if(arr[start]+arr[end]<diff){
                        start++;
                    }
                }
            }
        }

        return list;
    }
    /*
    static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        HashMap<Integer,Integer> m = new HashMap<>();
        Set<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = arr.length;

        for (int j : arr) {
            if (m.containsKey(j)) {
                m.put(j, m.get(j) + 1);
            } else {
                m.put(j, 1);
            }
        }

        for(int i=0;i<=n-4;i++){
            for(int j=i+1;j<=n-3;j++){
                for(int k=j+1;k<=n-2;k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    int diff = target - sum;

                    if(arr[i]!=arr[j] && arr[j]!=arr[k]){
                        // all are different
                        if(diff==arr[i] || diff==arr[j] || diff==arr[k]){
                            if(m.containsKey(diff)){
                                if(m.get(diff)>1){
                                    helper(arr[i],arr[j],arr[k],diff,hs,list);
                                }
                            }
                        }
                    }

                    else if(arr[i]==arr[j] && arr[j]==arr[k]){
                        // all are same
                        if(diff==arr[i]){
                            if(m.containsKey(diff)){
                                if(m.get(diff)>3){
                                    helper(arr[i],arr[j],arr[k],diff,hs,list);
                                }
                            }
                        }
                    }

                    else if(arr[i]==arr[j]){
                        // first two are same
                        if(diff==arr[i]){
                            if(m.containsKey(diff)){
                                if(m.get(diff)>2){
                                    helper(arr[i],arr[j],arr[k],diff,hs,list);
                                }
                            }
                        }
                    }

                    else if(arr[j]==arr[k]){
                        // last two are same
                        if(diff==arr[j]){
                            if(m.containsKey(diff)){
                                if(m.get(diff)>2){
                                    helper(arr[i],arr[j],arr[k],diff,hs,list);
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
*/
    static void helper(int first, int second, int third, int fourth, Set<ArrayList<Integer>> hs, ArrayList<ArrayList<Integer>> list){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(first);
        temp.add(second);
        temp.add(third);
        temp.add(fourth);
        Collections.sort(temp);

        if(!hs.contains(temp)) {
            list.add(temp);
            hs.add(temp);
        }
    }
}
