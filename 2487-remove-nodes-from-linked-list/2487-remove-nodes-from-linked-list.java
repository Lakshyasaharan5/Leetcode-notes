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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            while (!st.isEmpty() && st.peek().val < curr.val)
                st.pop();
            st.push(curr);
            curr = curr.next;
        }        
        // create list from st
        ListNode dummy = new ListNode(0);
        while (!st.isEmpty()) {
            ListNode top = st.pop();            
            top.next = dummy.next;
            dummy.next = top;
        }
        return dummy.next;
    }
}