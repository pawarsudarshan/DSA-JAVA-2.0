public class ReverseLinkedList {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr.next!=null){
            next = curr.next;
            curr.next = prev;
//            prev.next = null;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
