package DSA2.Arrays2;

public class MajorityElement {

    public static void main(String[] args) {
        int [] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;

        for(int i=1;i<nums.length;i++){
            if(candidate == nums[i]) count++;
            else{
                count--;
                if(count==0){
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        return candidate;
    }
}
