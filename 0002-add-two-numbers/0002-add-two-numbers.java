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
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int curr = l1.val + l2.val + carry;            
            carry = curr / 10;
            ListNode newNode = new ListNode(curr % 10);
            temp.next = newNode;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }   

        while (l1 != null || l2 != null) {
            int curr = (l1 != null ? l1.val : l2.val) + carry;
            carry = curr / 10;
            ListNode newNode = new ListNode(curr % 10);
            temp.next = newNode;
            temp = temp.next;
            if (l1 != null)
                l1 = l1.next;
            else 
                l2 = l2.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
            temp = temp.next;
        }

        return head.next;
    }
}