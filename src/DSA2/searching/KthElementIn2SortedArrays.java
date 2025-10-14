package DSA2.searching;
/*
Intuition: Binary Search on Answer
For Counting less than or Equal to Function: save and move right
For BS on Answer in main method: count>= k => save and move left

Optimal Solution: uses O(min(m,n)) time - similar to median of two sorted arrays
partition the arrays such that count of elements on the left = k - see commented code
*/
public class KthElementIn2SortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};
        int k = 5;
        System.out.println(findKthElement(arr1, arr2, k));
    }

    public static int findKthElement(int[] arr1, int[] arr2, int k) {
        int m = arr1.length, n = arr2.length;

        // Validate input
        if (k <= 0 || k > m + n) {
            throw new IllegalArgumentException("Invalid k: must be between 1 and total number of elements");
        }

        // Determine dynamic upper bound based on array contents
        int max1 = m > 0 ? arr1[m - 1] : Integer.MIN_VALUE;
        int max2 = n > 0 ? arr2[n - 1] : Integer.MIN_VALUE;
        int start = 0, end = Math.max(max1, max2), ans = 0;

        // Binary Search on Answer
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int countInArray1 = countLessThanOrEqualTo(arr1, mid);
            int countInArray2 = countLessThanOrEqualTo(arr2, mid);

            if (countInArray1 + countInArray2 >= k) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    public static int countLessThanOrEqualTo(int[] arr, int target) {
        if (arr.length == 0 || arr[0] > target) return 0;
        int start = 0, end = arr.length - 1, ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                ans = mid + 1;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }
}
//
//public static int findKthElement(int[] arr1, int[] arr2, int k) {
//    int m = arr1.length;
//    int n = arr2.length;
//
//    // Ensure arr1 is the smaller array
//    if (m > n) {
//        return findKthElement(arr2, arr1, k);
//    }
//
//    // Edge cases
//    if (k < 1 || k > m + n) {
//        throw new IllegalArgumentException("Invalid k");
//    }
//
//    int low = Math.max(0, k - n);
//    int high = Math.min(k, m);
//
//    while (low <= high) {
//        int cut1 = (low + high) / 2;
//        int cut2 = k - cut1;
//
//        int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
//        int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
//        int r1 = (cut1 == m) ? Integer.MAX_VALUE : arr1[cut1];
//        int r2 = (cut2 == n) ? Integer.MAX_VALUE : arr2[cut2];
//
//        if (l1 <= r2 && l2 <= r1) {
//            return Math.max(l1, l2);
//        } else if (l1 > r2) {
//            high = cut1 - 1;
//        } else {
//            low = cut1 + 1;
//        }
//    }
//
//    throw new RuntimeException("Unexpected condition");
//}

