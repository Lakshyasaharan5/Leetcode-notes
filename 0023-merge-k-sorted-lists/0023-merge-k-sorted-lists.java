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
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        for (ListNode node : lists) {
            if (node !=null)
                pq.add(node);
        }            
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            ListNode nextNode = curr.next;
            if (nextNode != null) pq.add(nextNode);
            tmp.next = curr;
            tmp = tmp.next;
        }
        return head.next;
    }
}