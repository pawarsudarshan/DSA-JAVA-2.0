package RandomDSAQuestions;

public class BoxPrice extends BoxWeight{
    double cost;

    BoxPrice(){
        super();
        this.cost = -1;
    }

    BoxPrice(double cost){
        super();
        this.cost = -1;
    }

    BoxPrice (double l, double w, double h, double weight, double cost){
        super(l,w,h,weight);
        this.cost = cost;
    }
}
