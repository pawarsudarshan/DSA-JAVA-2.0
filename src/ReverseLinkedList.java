public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.getSampleLinkedList();
        LinkedListUtils.printLinkedList(head);
        ListNode newHead = reverseList(head);
        LinkedListUtils.printLinkedList(newHead);
    }
    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next ==null) return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}