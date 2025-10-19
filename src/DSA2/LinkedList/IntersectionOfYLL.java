package DSA2.LinkedList;

public class IntersectionOfYLL {
    public static void main(String[] args) {

    }
    /* Approach 1 (Beginner Friendly) : find count of nodes for both the linked lists, let's say m and n
       move bigger linked list by m-n nodes and start traversing both linked list at once till then meet at a common node

       Approach 2 (Interview Ready): two pointers pA & pB, traverse to the end of linked list A and connect the last node of first linked list to the first
       node of the second linked list, thus forming a loop and then run slow and fast pointers to detect the loop/cycle.

       Approach 3 (Bit more Complex): reverse both the linked list, traverse the reversed linked list and find first point of deflection

     */

    // Approach 1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        int m = 0, n = 0;

        while(pA!=null){
            pA = pA.next;
            m++;
        }

        while(pB!=null){
            pB = pB.next;
            n++;
        }

        pA = headA; pB = headB;

        if(m>n){
            while(m-n>0){
                pA = pA.next;
                m--;
            }
        }

        else{
            while(n-m>0){
                pB = pB.next;
                n--;
            }
        }

        while(pA!=null && pB!=null){
            if(pA==pB){
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }

        return null;
    }

    // Approach 2
    /*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while(pA.next!=null){
            pA = pA.next;
        }
        ListNode lastNodeOfFirstLL = pA;
        pA.next = pB;

        ListNode slow = headA, fast = headA;
        boolean flag = false;

        do{
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                flag = true;
                break;
            }
        }while(fast!=null && fast.next!=null);

        if(flag){
            pA = headA; pB = slow;
            while(pA!=pB){
                pA = pA.next;
                pB = pB.next;
            }
            lastNodeOfFirstLL.next = null;
            return pA;
        }else{
            lastNodeOfFirstLL.next = null;
            return null;
        }
    }
     */


}
