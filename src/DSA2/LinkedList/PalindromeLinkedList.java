package DSA2.LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        int[] arr = {2,4,3};
        ListNode l1 = LinkedListUtils.createLinkedList(arr);
        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {
          // O(n) time O(n) space solution
//        List<Integer> list = new ArrayList<>();
//        ListNode curr = head;
//        while(curr!=null){
//            list.add(curr.val);
//            curr = curr.next;
//        }
//
//        int start = 0, end = list.size()-1;
//        while(start<=end){
//            if(list.get(start)!=list.get(end)){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;

        // O(n) time O(1) space solution
        if(head.next==null) return true;

        ListNode slow = head;
        ListNode fast = head;
        boolean ans = false;
        ListNode curr = head;
        ListNode prev = curr;

        while(true){
            if(fast.next!=null) fast = fast.next.next;
            prev = slow;
            if(slow.next!=null)
                slow = slow.next;

            if(fast==null){
                ListNode slowSaved = slow;
                ListNode reversed = reverseList(slow);
                ans = check(reversed,curr);

                ListNode newHead = reverseList(slow);
                prev.next = newHead;

                return ans;
            }
            else if(fast.next==null){
                ListNode slowSaved = slow;
                ListNode reversed = reverseList(slow.next);
                ans = check(reversed,curr);

                ListNode newHead = reverseList(reversed);
                slowSaved.next = newHead;


                return ans;
            }
        }
    }

    public static boolean check(ListNode head1, ListNode head2){
        while(head1!=null && head2!=null){
            if(head1.val!=head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
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
