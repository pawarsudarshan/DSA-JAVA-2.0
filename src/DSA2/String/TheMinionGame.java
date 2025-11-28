package DSA2.String;

public class TheMinionGame {
    public static void main(String[] args) {
        String str = "BANANA";
        System.out.println(minionGameSolver(str));
    }
    public static String minionGameSolver(String str){
        int cons = 0, vow = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U'){
                vow += str.length()-i;
            }else cons += str.length()-i;
        }
        if(vow>cons) return "Vowels-Win";
        else if(cons>vow) return "Consonants-Win";
        return "Draw";
    }
}
