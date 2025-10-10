package DSA2.linkedlist;

import java.util.List;

public class DeleteANodeinLL {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.getSampleLinkedList();
        LinkedListUtils.printLinkedList(head);
        int count = 3;
        ListNode curr = head;
        while(count>0){
            curr = curr.next;
            count--;
        }
        deleteNode(curr);
        LinkedListUtils.printLinkedList(head);
    }
    public static void deleteNode(ListNode node) {
        // move all element one position on left
        ListNode curr = node;
        ListNode prev = curr;
        while(curr.next!=null){
            curr.val = curr.next.val;
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;

        // much easier solution O(1)
        // just change the links of node and elements next to it

        // node.val = node.next.val;
        // node.next = node.next.next;

        // that's it
    }
}
