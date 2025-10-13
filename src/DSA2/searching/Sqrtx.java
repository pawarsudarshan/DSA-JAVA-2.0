package DSA2.searching;

public class Sqrtx {
    public static void main(String[] args) {
        int num = 29;
        System.out.println(mySqrt(num));
    }
    public static int mySqrt(int x) {
        int start = 0, end = x, ans = 0;

        while(start<=end){
            int mid = start + (end-start)/2;

            long square = (long) mid * (long) mid;
            if(square==(long)x) return mid;

            if(square < (long)x){
                ans = mid;
                start = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }
}
