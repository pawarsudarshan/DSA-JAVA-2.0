package DSA2.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        int[] arr = {2,4,2};
        ListNode l1 = LinkedListUtils.createLinkedList(arr);
        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }

        int start = 0, end = list.size()-1;
        while(start<=end){
            if(list.get(start)!=list.get(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
