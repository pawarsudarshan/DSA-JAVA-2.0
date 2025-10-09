package DSA2.arrays2;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int [] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = nums[0], fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast!=slow);

        slow = nums[0];
            while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

            return slow;
        }
}
