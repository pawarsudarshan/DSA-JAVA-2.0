package RandomDSAQuestions2;
import java.util.*;

public class MaximumSubArrayWithPositiveSum {
    public static void main(String[] args) {
        int[] arr = {13, 0, -6, -7, 9, -10, 10, -19};
        int n = arr.length;
        ArrayList<Integer> list = findSubarray(arr,n);
        System.out.println(list);
    }
    static ArrayList<Integer> findSubarray(int arr[], int n) {
        int startIndex=0,endIndex=0,maxSum=0,maxSumLen=0,sum=0;
        int tempStartIndex = 0, tempEndIndex = 0;

        for(int i=0;i<n;i++){

            if(arr[i]>=0){
                sum+=arr[i];
                tempEndIndex = i;
                if(sum>maxSum){
                    startIndex = tempStartIndex;
                    endIndex = tempEndIndex;
                    maxSumLen = endIndex-startIndex+1;
                    maxSum = sum;
                }

                else if(sum==maxSum){
                    int tempLength = tempEndIndex-tempStartIndex+1;
                    if(tempLength>maxSumLen){
                        startIndex = tempStartIndex;
                        endIndex = tempEndIndex;
                        maxSumLen = tempLength;
                    }
                }
            }

            else{
                sum=0;
                tempStartIndex = i+1;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        if(maxSumLen==0) {
            list.add(-1);
            return list;
        }

        for(int i=startIndex;i<=endIndex;i++){
            list.add(arr[i]);
        }

        return list;
    }
}
