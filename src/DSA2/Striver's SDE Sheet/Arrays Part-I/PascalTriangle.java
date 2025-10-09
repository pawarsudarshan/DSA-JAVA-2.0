import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        if(numRows==1) return triangle;

        for(int i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<=i;j++){
                int lastValue;
                if(j==i) {
                    lastValue = 0;
                }else{
                    lastValue = triangle.get(i-1).get(j);
                }
                int sum = triangle.get(i-1).get(j-1) +  lastValue;
                row.add(sum);
            }
            triangle.add(row);
        }

        return triangle;
    }
}
