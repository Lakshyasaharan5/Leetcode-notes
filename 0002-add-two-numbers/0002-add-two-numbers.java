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
        return solve(l1, l2, 0);
    }

    ListNode solve(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry > 0){
                return new ListNode(carry);
            }
            return null;
        }
        ListNode curr = null, tmp = null;
        int addition = 0;
        if(l1!=null && l2!=null){
            curr = l1;
            addition = l1.val + l2.val + carry;
            curr.val = addition % 10;
            tmp = solve(l1.next, l2.next, addition/10);
        }else{
            if(l1!=null){
                curr = l1;
                addition = l1.val + carry;
                curr.val = addition % 10;
                tmp = solve(l1.next, null, addition/10);
            }else{
                curr = l2;
                addition = l2.val + carry;
                curr.val = addition % 10;
                tmp = solve(null, l2.next, addition/10);
            }
        }        
        curr.next = tmp;
        return curr;
    }
}