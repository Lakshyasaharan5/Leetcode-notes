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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /**
             1 2 3 4 5
            [1,2,3,4,5]
               l   r
            
            1 -> 2 -> 3 -> 4 -> 5
            1 <> 2 <- 3 <- 4    5
            l              r    mark
            t = l.next
            l.next = r
            t.next = mark

                0    1    2    3
            dummy <> 1 <- 2    3   l=1 r=2
              lm
                          c   rm 
            t = lm.next
            lm.next = c
            t.next = rm
            return dummy.next
                     
         */
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        ListNode lm = null, rm = null;
        int i = 0;
        ListNode prev = null;
        while (curr != null) {
            if (i < left) {
                lm = curr;
                prev = lm;
                curr = curr.next;
            } else {                
                ListNode next = curr.next;
                rm = next;
                curr.next = prev;
                prev = curr;
                curr = next; 
                if (i == right) {
                    break;
                }               
            }
            i++;
        }
        ListNode t = lm.next;
        lm.next = prev;
        t.next = rm;
        return dummy.next;
    }
}