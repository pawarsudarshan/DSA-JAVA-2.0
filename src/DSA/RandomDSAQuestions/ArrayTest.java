package RandomDSAQuestions;

public class ArrayTest {
    public int testFunction(int i)
    {
        if(i<1) return 1;
        return 0;
    }

    public static void main(String[] args) {
        ArrayTest arr = new ArrayTest();
        int i= arr.testFunction(0);
        System.out.println(i);
    }
}
