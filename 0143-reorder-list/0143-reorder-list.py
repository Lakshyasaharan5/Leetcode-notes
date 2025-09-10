# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        start = head
        slow, fast = head, head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        l = c = None
        r = slow.next
        slow.next = None
        while r != None:
            c = r
            r = r.next
            c.next = l
            l = c

        first = start
        second = c
        while second:
            temp = first
            first = first.next
            temp.next = second
            second = second.next
            temp.next.next = first
        
         

        

