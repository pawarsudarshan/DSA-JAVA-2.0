package DSA2.Greedy;
import DSA2.BinaryTree.Pair;
import java.util.*;
/*
🧠 Greedy Approach: sort meetings by the end time.
The key to maximizing meetings is picking the ones that finish earliest — this leaves room for more
*/
public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        System.out.println(maxMeetings(start,end));
    }

    public static int maxMeetings(int[] start, int[] end){
        int n = start.length;
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(start[i],end[i]);
        }

        Arrays.sort(arr,(a,b)-> {
            if(a.second!=b.second) return a.second-b.second;
            return a.first-b.first;
        });

        int meetingEndTime = arr[0].second, meetingsCount = 1;
        for(int i=1;i<n;i++){
            if(arr[i].first>meetingEndTime){
                meetingEndTime = arr[i].second;
                meetingsCount++;
            }
        }
        return meetingsCount;
    }
}
