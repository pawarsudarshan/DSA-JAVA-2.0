package RandomDSAQuestions2;

public class JavaStrings {
    public static void main(String[] args) {
//        String str = new String("Sudarshan");
//        System.out.println(str);
////        System.out.println(str.charAt(11));
//
//        // indexOf(char) and lastIndexOf(char) gives -1 if the character is not present in the string
//
////        System.out.println(str.indexOf('a'));
////        System.out.println(str.lastIndexOf('z'));
//
////        System.out.println(str.indexOf("arsh"));
//
////        System.out.println(str.lastIndexOf("a", 9));
//
//        String str2 = String.valueOf(298);
//        System.out.println(str2);
//
//        boolean ex = true;
//        String str3 = String.valueOf(ex);
//
//        System.out.println(str3);
//
//        // integer to string valueOf() method
//        String str4 = String.valueOf(203);
//        System.out.println(str4);
//
//        // string to integer Integer.parseInt() method
//        int x = Integer.parseInt("10", 8);
//        System.out.println(x);

        // Construct string from character array :
        // Java have a constructor in String class which
        // directly converts char array to string
        // just pass the array name as arg in constructor
        char[] arr = {'r', 'a', 'v', 'i'};
        String str8 = new String(arr);
        System.out.println(str8);

        // Convert String to a character Array use toCharArray() method
        char[] arr2 = str8.toCharArray();
        System.out.println(arr2);


        // concat on strings + operator is overloaded for Strings

//        String str9 = new String("Sudarshan");
//        String str10 = new String("Suryakant");
//        str9 = str9.concat(str10);
//        str9 += "Pawar";
//        System.out.println(str9);

        JavaClass2 obj = new JavaClass2();
//        System.out.println(obj.x);

    }
}