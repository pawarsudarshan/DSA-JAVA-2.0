package DSA2.linkedlist;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printLinkedList(head);
        ListNode newHead = removeNthFromEnd(head,3);
        LinkedListUtils.printLinkedList(newHead);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // reverse
        // remove from front
        ListNode newHead = ReverseLinkedList.reverseList(head);
        // LinkedListUtils.printLinkedList(newHead);
        ListNode curr = newHead;

        if(n==1){
            return ReverseLinkedList.reverseList(newHead.next);
        }

        int count = 2;

        while(curr!=null && curr.next!=null){
            if(count == n){
                curr.next = curr.next.next;
                break;
            }
            curr= curr.next;
            count ++;
        }

        return ReverseLinkedList.reverseList(newHead);
    }
}
