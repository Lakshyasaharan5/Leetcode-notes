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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int cp = -1, fcp = -1;
        ListNode prev = head, curr = head.next;
        int idx = 0;
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;
        while (curr.next != null) {
            // logic
            if ((prev.val < curr.val && curr.val > curr.next.val) || (prev.val > curr.val && curr.val < curr.next.val)) {
                if (fcp == -1) {
                    fcp = idx;
                    cp = idx;                    
                } else {
                    minDist = Math.min(minDist, idx - cp);
                    maxDist = Math.max(maxDist, idx - fcp);
                    cp = idx;
                }
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }
        if (minDist == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        } 
        return new int[]{minDist, maxDist};
    }
}