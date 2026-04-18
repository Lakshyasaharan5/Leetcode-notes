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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode a, ListNode b, int c) {
        if (a == null && b == null && c == 0) return null;
        int sum = c;
        if (a != null) {
            sum += a.val;
            a = a.next;
        }
        if (b != null) {
            sum += b.val;
            b = b.next;
        }
        c = sum / 10;
        ListNode curr = new ListNode(sum % 10);
        curr.next = addTwoNumbers(a, b, c);
        return curr;
    }
}