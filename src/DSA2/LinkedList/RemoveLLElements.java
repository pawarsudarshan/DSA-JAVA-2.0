package DSA2.LinkedList;
/* Problem Statement: Given the head of a linked list and an integer val,
remove all the nodes of the linked list that has Node.val == val, and return the new head.

Important problem
 */
public class RemoveLLElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next =head;

        ListNode curr = dummy, prev = null;

        while(curr!=null){
            if(curr.val==val){
                prev.next = curr.next;
            } else prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}
