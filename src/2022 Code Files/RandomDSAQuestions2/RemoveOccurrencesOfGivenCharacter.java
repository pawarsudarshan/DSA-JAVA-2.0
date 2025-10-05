package RandomDSAQuestions2;

import java.util.*;

public class RemoveOccurrencesOfGivenCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);

        StringBuilder s = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=ch){
                s.append(str.charAt(i));
            }
        }

        str = s.toString();
        System.out.println(str);
    }
}
