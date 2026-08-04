/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        /**
            dummy - 1 - 2 - 3 - 4
                        p           n
               while p.next and p.next.next
                left = p.next
                right = p.next.next
                swap(left,right)
                p = next.next
                n = next.next

               d - 1 - 2
               p          n
               d - 1
               p
               return d.next
         */

        ListNode d = new ListNode(-1, head);
        ListNode p = d;
        while (p.next != null && p.next.next != null) {
            ListNode n = p.next.next.next;
            ListNode l = p.next;
            ListNode r = p.next.next;
            //swap
            p.next = r;            
            r.next = l;
            l.next = n;
            p = p.next.next;
        }
        return d.next;
    }
}