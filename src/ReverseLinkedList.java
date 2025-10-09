import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next ==null) return head;

        ListNode  curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
