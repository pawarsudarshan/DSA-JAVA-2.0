package DSA2.Arrays3;
/*
Approach:
Calculate maxProduct both ways -
Left to right pass
Right to left pass
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums){
        int n = nums.length;
        int max = nums[0];

        int product = 1;
        // Left to right pass
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            max = Math.max(max, product);
            if (product == 0) product = 1;
        }

        product = 1;
        // Right to left pass
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(max, product);
            if (product == 0) product = 1;
        }

        return max;
    }

}
