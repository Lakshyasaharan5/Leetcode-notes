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
    public ListNode partition(ListNode head, int x) {
        // |-----------|
        //             |-------|  
        // 1   4 - 3   2   5   2
        //         |-------|       
        //                        t
        //                     s   
        //                 b   
        //    bs        
        // r        
        
        // if s or b == null
        // 1 assign s or b as temp
        // 2 increment temp
        // 3 put s or b next to null

        // else
        // 1 put b/s next = t
        // 2 put b/s = b/s.next
        // 3 put t = t.next
        // 4 put b/s.next = null

        ListNode small=null, big=null, temp=head, res=null, big_start=null;
        while(temp!=null){
            if(temp.val<x){
               if(small==null){
                   res = temp;
                   small = temp;
                   temp = temp.next;
                   small.next = null;                   
               }else{
                   small.next = temp;
                   small = small.next;
                   temp = temp.next;
                   small.next = null;
               }
            }else{
                if(big==null){
                   big = temp;
                   big_start=temp;
                   if(small==null)
                        res = big;
                   temp = temp.next;
                   big.next = null;
               }else{
                   big.next = temp;
                   big = big.next;
                   temp = temp.next;
                   big.next = null;
               }
            }
        }
        if(small!=null)
            small.next = big_start;
        return res;
    }
}