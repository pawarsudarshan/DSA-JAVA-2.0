package RandomDSAQuestions2;

import java.util.Scanner;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println("The duplicate number is: "+ findDuplicate(arr));
    }
    public static int findDuplicate(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i]);
            if(nums[index]<0) return index;
            nums[index] = - nums[index];
        }

        return -1;
    }
}
