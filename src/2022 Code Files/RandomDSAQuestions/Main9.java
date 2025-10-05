package RandomDSAQuestions;

class Complex {
    double  real, imaginary;
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
}

public class Main9 {
    public static void main(String[] args) {
        Complex obj = new Complex(10, 15);

        System.out.println(obj.real);
        System.out.println(obj.imaginary);

        System.out.println(obj);
    }
}