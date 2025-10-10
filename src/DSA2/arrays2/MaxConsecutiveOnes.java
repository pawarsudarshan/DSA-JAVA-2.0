package DSA2.arrays2;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,0,0,0,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxcount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                maxcount = Math.max(count,maxcount);
            }
            else{
                count = 0;
            }
        }
        return maxcount;
    }
}
