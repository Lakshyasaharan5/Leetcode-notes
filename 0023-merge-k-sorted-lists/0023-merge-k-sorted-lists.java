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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            if (top.next != null) pq.offer(top.next);
            top.next = null;
            temp.next = top;
            temp = temp.next;
        }
        return head.next;
    }
}