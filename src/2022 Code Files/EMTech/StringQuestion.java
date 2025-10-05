package EMTech;

public class StringQuestion {

    public static int helper(String text, String str)
    {
        if (text.length()==0 || str.length()==0) return 0;
        int ind = 0, cnt = 0;

        while (true) {
            ind = text.indexOf(str, ind);
            if (ind != -1) {
                cnt ++;
                ind ++;
            }
            else break;
        }

        return cnt;
    }

    public static void Occurrences(int n, String s){
//        int result = -404;

        for(int i=0;i<n;i++){
            String temp = s.substring(0,i+1);
            System.out.print(helper(s,temp) + " ");
        }

//        System.out.println(result);
    }




    public static void main(String[] args) {
        String s = "aaaaa";
        Occurrences(s.length(),s);
    }
}
