package RandomDSAQuestions;

public class InnerClasses {
//    int salary;
    class GreetingClass{
        void greet(){
            System.out.println("Good Morning...");
//            System.out.println(salary);
        }
    }

    public static void main(String[] args) {
//        GreetingClass obj = new GreetingClass();
//        obj.greet();

        InnerClasses obj = new InnerClasses();
        GreetingClass obj2 = obj.new GreetingClass();

        obj2.greet();
    }
}