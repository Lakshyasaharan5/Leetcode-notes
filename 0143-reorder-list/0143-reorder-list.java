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
    public void reorderList(ListNode head) {
        // reach the middle using slow and fast
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ptr_to_second_half = null;
        if(fast == null){ // even length
            ptr_to_second_half = slow;
        }else{
            ptr_to_second_half = slow.next;
        }

        // put the right half into stack
        Stack<ListNode> stack = new Stack<>();
        while(ptr_to_second_half!=null){
            stack.push(ptr_to_second_half);
            ptr_to_second_half = ptr_to_second_half.next;
        }


        // merge both the halves
        ListNode tmp = head;
        while(!stack.empty()){
            ListNode top = stack.pop();
            top.next = head.next;
            head.next = top;
            head = top.next;
        }
        head.next = null;
    }
}