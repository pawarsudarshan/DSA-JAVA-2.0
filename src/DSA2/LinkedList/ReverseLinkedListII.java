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
        // Edge case: if head is null or no reversal needed
        if (head == null || left == right) return head;

        ListNode prev = null;
        ListNode curr = head;
        int pos = 1;

        // Pointers for connecting reversed segment
        ListNode lhsNode = null;   // Node before 'left' position
        ListNode rhsNode = null;   // Node after 'right' position
        ListNode leftNode = null;  // First node of the segment to reverse
        ListNode rightNode = null; // Last node of the reversed segment

        // Step 1: Move curr to 'left' position
        while (pos < left) {
            lhsNode = curr;
            curr = curr.next;
            pos++;
        }

        // Step 2: Reverse nodes between 'left' and 'right'
        leftNode = curr;           // Mark start of reversal
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            pos++;

            if (pos == right + 1) {    // Stop when right boundary reached
                break;
            }
        }

        // Step 3: Connect reversed segment back to list
        rhsNode = curr;            // Node after reversed segment
        rightNode = prev;          // Last node of reversed segment

        if (lhsNode != null) {
            lhsNode.next = rightNode;  // Connect left part to reversed segment
        }

        if(leftNode != null){
            leftNode.next = rhsNode;       // Connect reversed segment to right part
        }

        // If reversal started at head, update head
        return (left == 1) ? rightNode : head;
    }

}
