package RandomDSAQuestions2;// Kunal Kushwaha OOP lecture 2
// #OOP2 #KunalKushwaha

public class OOPLecture2 {
    public static void main(String[] args) {
        Human sudarshan = new Human(21, "Suarshan", 65000,false);

        System.out.println(Human.population);

        Human vishal = new Human(22, "Vishal", 50000, false);

        System.out.println(Human.population);

        greet();
    }

    static void greet(){
        System.out.println("Hello this is a greeting...");
    }

}

class Human{
    int age;
    String name;
    int salary;
    boolean isMarried;
    static int population;

    Human (int age, String name, int salary, boolean isMarried){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.isMarried = isMarried;
        population++;
    }
}
