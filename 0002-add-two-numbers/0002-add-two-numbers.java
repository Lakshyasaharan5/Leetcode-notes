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
        //     l1-1-2
        //            ^       
        //     l2-1-2-3-4-5-6 
        //            ^
        //    t,r-2-4-3-4-5-6 
        ListNode tmp = new ListNode();
        ListNode res = tmp;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;            
            tmp.next = new ListNode(sum%10);                        
            carry = sum/10;
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = carry + l1.val;
            tmp.next = new ListNode(sum%10);                        
            carry = sum/10;
            tmp = tmp.next;
            l1 = l1.next;
        }     
        while (l2 != null) {
            int sum = carry + l2.val;
            tmp.next = new ListNode(sum%10);                        
            carry = sum/10;
            tmp = tmp.next;
            l2 = l2.next;
        }        
        if (carry > 0) {
            tmp.next = new ListNode(carry);
        }
        return res.next;
    }
}