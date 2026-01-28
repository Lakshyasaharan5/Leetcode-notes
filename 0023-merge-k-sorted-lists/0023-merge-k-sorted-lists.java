class Solution {
    public ListNode mergeKLists(ListNode[] lists) {                  
        if (lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }    

    private ListNode mergeSort(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        
        int m = (l + r) / 2;
        ListNode left = mergeSort(lists, l, m);
        ListNode right = mergeSort(lists, m + 1, r);        

        if (left == null) return right;
        if (right == null) return left;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp.next.next = null;
            temp = temp.next;
        }

        if (left != null) temp.next = left;
        if (right != null) temp.next = right;

        return dummy.next;
    } 
}