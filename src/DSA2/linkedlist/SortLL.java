package DSA2.linkedlist;
import java.util.*;

public class SortLL {
    public static void main(String[] args) {

    }
    public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(list);
        curr = head;
        int i = 0;
        while(curr!=null){
            curr.val = list.get(i);
            i++;
            curr = curr.next;
        }

        return head;
    }
}
