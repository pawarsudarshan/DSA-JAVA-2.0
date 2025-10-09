package BinarySearch;

import java.util.*;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = { 10, 1, 2, 7, 5 };
        int n = stalls.length;
        int k = 3;
        System.out.println(solve(n, k, stalls));
    }

    public static int solve(int n, int k, int[] stalls) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(stalls);
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, stalls[i + 1] - stalls[i]);
        }

        int start = min, end = stalls[n - 1] - stalls[0], ans = min;
        // System.out.println(start+" "+end);
        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(stalls, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    static boolean check(int[] stalls, int k, int mid) {
        int prevCow = stalls[0];
        k--;
        for (int i = 1; i < stalls.length; i++) {
            int dist = stalls[i] - prevCow;
            if (dist >= mid) {
                prevCow = stalls[i];
                k--;
            }
            if (k == 0)
                return true;
        }
        return false;
    }
}
