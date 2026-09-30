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
    /**
        1-2-3
          s
            f
        reach the half
        while(f, f.next, f.next.next)

        reverse the second half

        merge recursively

      <-1 2->3
      p c  n


        1- 4-2 -> 3
             f    fn
        4    5
             s    sn

        1-4-2-5-3
                f
        5
          s
     */
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null, curr = second;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        second = prev;

        ListNode first = head;

        // mergeIteratively(first, second);
        head = mergeRecursively(first, second);
    }

    /**
        1
        f
        4
        s

        f.next = s
        s.next = rec(f.next, s.next)
        return f

     */
    private ListNode mergeRecursively(ListNode f, ListNode s) {
        if (f == null) return s;
        if (s == null) return f;
        ListNode fn = f.next;
        f.next = s;
        s.next = mergeRecursively(fn, s.next);
        return f;
    }

    private void mergeIteratively(ListNode f, ListNode s) {
        while (f != null && s != null) {
            ListNode fn = f.next;
            ListNode sn = s.next;
            f.next = s;
            s.next = fn;
            f = fn;
            s = sn;
        }
    }
}