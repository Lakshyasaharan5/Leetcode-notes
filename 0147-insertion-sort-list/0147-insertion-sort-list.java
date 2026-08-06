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
    public ListNode insertionSortList(ListNode head) {
        /**
                4 -> 2 -> 1 -> 3

                     3
                     ^
                d - 1 - 2 - 3 - 4 
        
         */

        ListNode d = new ListNode(-1);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = null;
            insert(d, curr); 
            curr = next;           
        }
        return d.next;
    }

    private void insert(ListNode d, ListNode c) {
        ListNode tmp = d;
        while (tmp.next != null && tmp.next.val < c.val) {
            tmp = tmp.next;
        }
        c.next = tmp.next;
        tmp.next = c;
    }
}