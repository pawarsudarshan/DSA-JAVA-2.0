package DSA2.searching;

public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1};
        int[] arr2 = {1, 1, 5};
        System.out.println(medianOf2Arrays(arr1,arr2));
    }

    public static double medianOfSingleArray(int[] arr){
        int n = arr.length;
        if((n&1)==1) return (double) arr[n/2];
        return (double) (arr[n/2-1]+arr[n/2])/2;
    }

    public static int lessThanOrEqualInOneArray(int[] arr, int target){
        int start = 0, end = arr.length-1, count = 0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]<=target){
                count = mid + 1;
                start = mid+1;
            }else end = mid-1;
        }
        return count;
    }

    public static int lessThanOrEqualInTwoArrays(int[] arr1, int[] arr2, int target){
        return lessThanOrEqualInOneArray(arr1,target) + lessThanOrEqualInOneArray(arr2,target);
    }

    public static double medianOf2Arrays(int[] arr1, int[] arr2) {
        if(arr1.length==0 && arr2.length==0) return -1;
        if(arr1.length==0) return medianOfSingleArray(arr2);
        if(arr2.length==0) return medianOfSingleArray(arr1);

        int start = Math.min(arr1[0], arr2[0]), end = Math.max(arr1[arr1.length - 1], arr2[arr2.length - 1]);
        int totalLength = arr1.length + arr2.length;
        int leftHalf = totalLength/2;
        int rightHalf = totalLength/2 + 1;
        int rightAns = solve(arr1,arr2,rightHalf);

        if((totalLength&1)==1){
            return rightAns;
        }

        int leftAns = solve(arr1,arr2,leftHalf);
        return (double) (leftAns + rightAns)/2;
    }

    public static int solve(int[] arr1, int[] arr2, int target){
        int start = Math.min(arr1[0], arr2[0]), end = Math.max(arr1[arr1.length - 1], arr2[arr2.length - 1]);
        int ans = 0;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(lessThanOrEqualInTwoArrays(arr1,arr2,mid)>=target){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }

        return ans;
    }
}
