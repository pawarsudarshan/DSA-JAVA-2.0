package DSA2.LeetCodeContests;

public class Solution {
    public static void main(String[] args) {
//        Q1
        System.out.println(minimumFlips(10));
//        Q2
        System.out.println(totalWaviness(120,130));
    }
//     Answer to Q1
    public static int minimumFlips(int n) {
        String binary = Integer.toBinaryString(n);
        int i=0,j=binary.length()-1, count = 0;
        while(i<binary.length()){
            if(binary.charAt(i)!=binary.charAt(j))
                count++;
            i++;
            j--;
        }
        return count;
    }

    public static int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i=num1;i<=num2;i++){
            count += check(i);
        }
        return count;
    }
    public static int check(int n){
        if(n<100) return 0;
        int count = 0;
        String s = String.valueOf(n);

        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        for(int i=1;i<digits.length-1;i++){
            if(digits[i]>digits[i-1] && digits[i]>digits[i+1]) count++;
            if(digits[i]<digits[i-1] && digits[i]<digits[i+1]) count++;
        }
        return count;
    }
}
