package DSA2.linkedlist;

// slow and fast pointer approach, they will meet if cycle is present

public class DetectCycleLL {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) return true;
        }

        return false;
    }
}
