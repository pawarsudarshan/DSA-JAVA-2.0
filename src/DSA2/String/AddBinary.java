package DSA2.String;
import java.util.*;
/*

*/
public class AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        StringBuilder sb = new StringBuilder();
        int i=m-1,j=n-1, carry = 0;

        while(i>=0 || j>=0){
            int first = 0, second = 0;
            if(i>=0){
                first = a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                second = b.charAt(j)-'0';
                j--;
            }
            int sum = first+second+carry;
            if(sum==2){
                sb.append('0');
                carry = 1;
            }
            else if(sum==3){
                sb.append('1');
                carry = 1;
            }else if(sum==1){
                sb.append('1');
                carry = 0;
            }else{
                sb.append('0');
                carry = 0;
            }
        }

        if(carry==1) sb.append('1');
        sb.reverse();
        return sb.toString();
    }
}
