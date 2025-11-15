package DSA2.Recursion;

public class RegExMatching {
    public static void main(String[] args) {
        String s = "aaacbb";
        String p = "a*.b*";
        System.out.println(isMatch(s,p));

    }
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int i=0,j=0;
        boolean isStar = false;
        while(i<m && j<n){
            if(j+1<n && p.charAt(j)=='.' && p.charAt(j+1)=='*'){
                // none

                // present


            }
            else if(j+1<n && p.charAt(j+1)=='*'){
                char x = p.charAt(j);
                isStar = true;
                if(x==s.charAt(i)){
                    System.out.println("Same Char = "+x);
                    i++;
                }else{
                    j = j+2;
                }
            }
            else if(p.charAt(j)=='.'){
                i++;
                j++;
            }
            else if(s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }
            else return false;
        }
        if(i>=m && j>=n) return true;
        if(i>=m && j+1<n && p.charAt(j+1)=='*') return true;
        return false;
    }
    public static boolean solve(String s, String p, int i, int j){
        // Base case
        if(i==s.length() && j==p.length()) return true;
        // more base cases to follow
        if(i>=s.length() || j>=p.length()) return false;

        // check for dot => correct
        if(p.charAt(j)=='.'){
            return solve(s,p,i+1,j+1);
        }

        // check for star
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            // two cases
            boolean way1 = false, way2 = false;

            //match
            if(s.charAt(i)==p.charAt(j)){
                way1 = solve(s,p,i+1,j);
            }

            // don't match
            way2 = solve(s,p,i,j+2);

            return way1 || way2;
        }

        if(s.charAt(i)==p.charAt(j))
            return solve(s,p,i+1,j+1);

        return false;
    }
}
