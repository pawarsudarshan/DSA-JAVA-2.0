package RandomDSAQuestions;

public class Singleton {
    private Singleton(){

    }

    static Singleton instance ;

    void printName(){
        System.out.println("My name is Sudarshan");
    }

    public static Singleton getInstance(){
        if(instance == null) {
            instance = new Singleton();
            return instance;
        }

        return instance;
    }

}
