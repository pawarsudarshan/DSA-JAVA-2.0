package DSA2.LinkedList;

public class RotateLLbyNPlaces {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.getSampleLinkedList();
        LinkedListUtils.printLinkedList(head);
        ListNode newHead = rotateRight(head,2);
        LinkedListUtils.printLinkedList(newHead);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode curr = head;
        int count = 0;

        while(curr!=null) {
            if (curr.next == null) {
                count++;
                curr.next = head;
                break;
            }
            curr = curr.next;
            count++;
        }

        k = k%count;
        int n = count -k;
        curr = head;

        for(int i=1;i<n;i++){
            curr = curr.next;
        }
        ListNode ans = curr.next;
        curr.next = null;

        return ans;
    }
}
