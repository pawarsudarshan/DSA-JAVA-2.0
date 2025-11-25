package DSA2.LinkedList;

import java.util.List;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printLinkedList(head); // Before Reversing
        ListNode reversedHead = reverseBetween(head,2,4);
        LinkedListUtils.printLinkedList(head); // After Reversing
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Dummy node to handle edge cases like reversing from head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // lhsNode: node before the reversal segment
        ListNode lhsNode = dummy;
        for (int pos = 1; pos < left; pos++) {
            lhsNode = lhsNode.next;
        }

        // leftNode: first node of the segment to reverse
        ListNode leftNode = lhsNode.next;
        ListNode curr = leftNode.next;

        // Reverse the segment
        for (int i = 0; i < right - left; i++) {
            leftNode.next = curr.next;
            curr.next = lhsNode.next;
            lhsNode.next = curr;
            curr = leftNode.next;
        }

        return dummy.next;
    }
}
