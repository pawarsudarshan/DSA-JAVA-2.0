package RandomDSAQuestions;

public class TestSingleton {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        obj.printName();
        System.out.println(obj);

        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();

        System.out.println(obj3);

        Singleton obj4 = Singleton.getInstance();
        Singleton obj5 = Singleton.getInstance();

        System.out.println(obj5);
    }
}
