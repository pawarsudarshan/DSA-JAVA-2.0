package DSA2.arrays2;

public class EqualScoreSubstrings {
    public static void main(String[] args) {
        String s = "abdeioisj";
        System.out.println(scoreBalance(s));
    }
    public static boolean scoreBalance(String s) {
        boolean answer = false;
        int sum = 0, allsum = 0;

        for(int i=0;i<s.length();i++){
            int value = (int)s.charAt(i) - 96;
//            System.out.println("Value of char "+s.charAt(i)+ " "+ value);
            allsum += value;
        }

        for(int i=0;i<s.length();i++){
            int value = (int)s.charAt(i) - 96;
            sum += value;
            if(sum==(allsum-sum)){
                answer = true;
                return answer;
            }
        }
        return answer;
    }
}
