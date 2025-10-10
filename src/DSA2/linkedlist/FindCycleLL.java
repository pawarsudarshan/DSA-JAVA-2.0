package DSA2.linkedlist;

public class FindCycleLL {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow){
                ListNode curr = head;
                while(curr!=slow){
                    curr = curr.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }


}
