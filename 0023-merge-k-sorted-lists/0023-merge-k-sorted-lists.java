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
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node!=null)
                pq.add(node);
        }   
        if(pq.size() == 0) return null;
        ListNode tmp = pq.poll();
        ListNode head = tmp;
        if(tmp!=null && tmp.next!=null) pq.add(tmp.next);    
        while(pq.size() > 0){
            ListNode top = pq.poll();
            tmp.next = top;
            if(top!=null && top.next!=null) pq.add(top.next);    
            tmp = tmp.next;
        }
        return head;
    }
}