package DSA2.Arrays3;

public class KLengthsApart {
    public static void main(String[] args) {
        int[] nums = {1,0,0,1,0,0,0,1};
        int k = 2;
        System.out.println(kLengthApart(nums, k));
    }
    public static boolean kLengthApart(int[] nums, int k) {
        int prev = -123456;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(i-prev<=k) return false;
                prev = i;
            }
        }
        return true;
    }
}
