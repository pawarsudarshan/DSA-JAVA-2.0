package RandomDSAQuestions;

public class StaticBlockJava {
    static int a = 4;
    static int b;

    static {
        System.out.println("I am in the static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        StaticBlockJava obj = new StaticBlockJava();
        System.out.println(obj.a + " " + obj.b);

        obj.b += 3;

        StaticBlockJava obj2 = new StaticBlockJava();
        System.out.println(obj.a + " " + obj.b);
    }
}
