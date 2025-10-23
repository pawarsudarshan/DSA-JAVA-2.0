package DSA2.LinkedList;
/*
    this problem tests your maneuvers with the pointers
*/
public class ReverseNodesInGroupOfK {
    public ListNode reverseKGroup(ListNode head, int k) {
        int savedK = k, count = 0;
        ListNode curr = head, next = null, prev = null, ansHead = null, prevOfLast = null;

        while(curr!=null){
            ListNode tempHead = curr; // also lastOfPrev

            // finding last node
            while(k>0 && curr!=null){
                next = curr.next;
                prev = curr;
                curr = next;
                k--;
            }
            if(k!=0 && prevOfLast!=null){
                prevOfLast.next = tempHead;
                break;
            }
            prev.next = null; // prev is the last node of current group

            ListNode reversed = reverseLL(tempHead);

            if(count==0){
                ansHead = reversed;
                prevOfLast = tempHead;
            }

            if(count!=0){
                prevOfLast.next = reversed;
            }

            prevOfLast =  tempHead;
            count++;
            k = savedK;
        }
        return ansHead;
    }

    public ListNode reverseLL(ListNode head){
        ListNode curr = head, prev = null, next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
