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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // 1-2-4--5-6
        //     ^    ^
        
        if(head.next==null)
            return null;
        
        if(head.next.next==null){
            if(n==1){
                head.next=null;
                return head;
            }
            if(n==2)
                return head.next;
        }
        
        if(n==1){
            ListNode temp = head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
            return head;
        }
        
        ListNode first = head;
        ListNode second = head;
        while(--n > 0){
            second=second.next;
        }
        while(second.next!=null){
            first=first.next;
            second=second.next;
        }
        first.val=first.next.val;
        first.next = first.next.next;
        
        return head;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // if(head.next==null){
        //     return null;
        // }
        // ListNode fast = head;
        // for(int i=0; i<n; i++){
        //     fast = fast.next;
        // }
        // ListNode slow = head;
        // if(fast==null){
        //     return head.next;
        // }
        // while(fast.next!=null){
        //     slow = slow.next;
        //     fast = fast.next;
        // }
        // slow.next = slow.next.next;
        // return head;
        
    }
}