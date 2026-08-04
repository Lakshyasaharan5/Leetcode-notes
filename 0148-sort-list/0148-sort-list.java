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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode f = head, s = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode other_half = s.next;
        s.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(other_half);
        return merge(left, right);
        /**
            4 1 2 3
            [41]. [23]
            [4][1]  [2][3]
            l r
            return merge(l,r)

            1 - 2 - 3
                s
                     f 
            while f.next and f.next.next
                s = s.next
                f = f.next.next

            head
            s.next
            
        
         */
        
    }

    private ListNode merge(ListNode a, ListNode b) {
        /*        
            1 - 5
                a
            2 - 6
            b
            d - 1
        */
        ListNode d = new ListNode(-1);
        ListNode c = d;
        while (a != null && b != null) {
            if (a.val < b.val) {
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }
            c = c.next;
        }
        if (a != null) c.next = a;
        if (b != null) c.next = b;
        return d.next;
    }
}