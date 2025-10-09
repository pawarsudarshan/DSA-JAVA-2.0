package BinarySearch;

// import java.lang.reflect.Array;
import java.util.*;

public class CountingElementsInTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = { 4, 8, 7, 5, 1 };
        int[] arr2 = { 4, 48, 3, 0, 1, 1, 5 };

        ArrayList<Integer> list = countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length);
        System.out.println(list);
    }

    static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr2);

        for (int i = 0; i < m; i++) {
            int count = ceilingOfANumber(arr2, arr1[i]);
            list.add(count);
        }

        return list;
    }

    static int ceilingOfANumber(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = arr.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        // System.out.println("The value of target and index is : " + target + " "+
        // ans);
        return ans;
    }
}
