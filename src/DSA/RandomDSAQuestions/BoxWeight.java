package RandomDSAQuestions;

public class BoxWeight extends Box{
    double weight ;

    BoxWeight(){}

    BoxWeight(double weight){
        this.weight = weight;
    }

    BoxWeight(double l, double w, double h, double weight){
        super(l,w,h); // super keyword calls the parent class constructor
        this.weight = weight;
    }
}