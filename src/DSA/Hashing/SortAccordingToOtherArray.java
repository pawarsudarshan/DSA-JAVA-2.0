package Hashing;
import java.lang.reflect.Array;
import java.util.*;

public class SortAccordingToOtherArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] arr2 = {2, 1, 8, 3};
        int[] answer = sortA1ByA2(arr1, arr1.length, arr2, arr2.length);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] sortA1ByA2(int arr1[], int m, int arr2[], int n){
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> set1 = new HashSet<>();

        int len = arr1.length;
        int[] output = new int[len];

        for(int i=0;i<m;i++){
            if(hm.containsKey(arr1[i])){
                int val = hm.get(arr1[i]);
                hm.put(arr1[i], val+1);
            }else{
                hm.put(arr1[i],1);
            }
        }
        int k = 0;

        for(int i=0;i<n;i++){
            if(set1.contains(arr2[i])) continue;
            if(hm.containsKey(arr2[i])){
                int count = hm.get(arr2[i]);
                for(int j=0;j<count;j++){
                    output[k++] = arr2[i];
                }
            }

            set1.add(arr2[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            if(set1.contains(arr1[i])) continue;
            else{
                list.add(arr1[i]);
            }
        }

        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            output[k++] = list.get(i);
        }

        return output;
    }
}
