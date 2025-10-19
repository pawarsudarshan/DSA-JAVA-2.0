package DSA2.LinkedList;
// understand the question properly
// LeetCode 2
// in question it was given that the numbers are stores in reverse order and the evaluation will be done in reverse order as well
// so there was no need to reverse the linkedlist

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        ListNode l1 = LinkedListUtils.createLinkedList(arr1);
        ListNode l2 = LinkedListUtils.createLinkedList(arr2);
        LinkedListUtils.printLinkedList(addTwoNumbers(l1,l2));
    }
    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode curr = ans;

        int sum = 0, carry = 0, list1Value = 0, list2Value = 0;
        while(true){
            if(list1!=null){
                list1Value = list1.val;
                list1 = list1.next;
            } else list1Value = 0;

            if(list2!=null){
                list2Value = list2.val;
                list2 = list2.next;
            } else list2Value = 0;

            sum = list1Value + list2Value + carry;
            carry = sum/10;

            curr.next = new ListNode(sum%10);
            curr = curr.next;

            if(list1==null && list2==null) break;
        }

        if(carry!=0) {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }

        return ans.next;
    }
}
