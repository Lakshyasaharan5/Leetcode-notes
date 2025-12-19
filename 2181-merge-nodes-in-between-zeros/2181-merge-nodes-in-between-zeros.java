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
    public ListNode mergeNodes(ListNode head) {
                // [0,3,4,0,4,5,2,0]
                //  d
                //  p
                //      c
        ListNode dummy = head, prev = head, curr = head.next;
        int curr_sum = 0;
        while (curr != null) {
            curr_sum += curr.val;
            curr.val = curr_sum;
            if (curr.next.val == 0) {                
                curr_sum = 0;
                curr.next = curr.next.next;
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            } else {                
                curr = curr.next;                
            }
        }

        return dummy.next;
    }
}