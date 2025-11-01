package DSA2.Arrays3;
import java.util.*;
import DSA2.BinaryTree.Pair;

public class MergeOverlappingSubintervals {
    public int[][] merge(int[][] intervals) {
        List<Pair> res = new ArrayList<>();
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            list.add(new Pair(intervals[i][0],intervals[i][1]));
        }

        // sort the list on first, if equal then on second
        Collections.sort(list, (a, b) -> (a.first == b.first) ? a.second - b.second : a.first - b.first);

        int currStart = list.get(0).first, currEnd = list.get(0).second;
        for(int i=1;i<intervals.length;i++){
            if(list.get(i).first<=currEnd){
                currEnd = Math.max(currEnd,list.get(i).second);
            }else{
                res.add(new Pair(currStart,currEnd));
                currStart = list.get(i).first;
                currEnd = list.get(i).second;
            }
        }

        res.add(new Pair(currStart,currEnd));

        int[][] finalAns = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            finalAns[i][0] = res.get(i).first;
            finalAns[i][1] = res.get(i).second;
        }
        return finalAns;
    }
}