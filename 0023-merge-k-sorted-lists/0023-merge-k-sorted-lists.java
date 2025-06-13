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
        if (lists.length == 0)
            return null;
        return mergesort(lists, 0, lists.length - 1);
    }

    ListNode mergesort(ListNode[] lists, int l, int h) {
        if (l == h)
            return lists[l];
        int m = l + (h - l) / 2;
        ListNode left = mergesort(lists, l, m);
        ListNode right = mergesort(lists, m + 1, h);
        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left != null ? left : right;
        return head.next;
    }
}