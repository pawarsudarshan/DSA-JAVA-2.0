package DSA2.linkedlist;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.getSampleLinkedList();
        LinkedListUtils.printLinkedList(head);
        ListNode newHead = middleNode(head);
        LinkedListUtils.printLinkedList(newHead);
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}