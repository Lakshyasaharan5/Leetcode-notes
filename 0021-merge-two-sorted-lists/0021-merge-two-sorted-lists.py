# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(
        self, list1: Optional[ListNode], list2: Optional[ListNode]
    ) -> Optional[ListNode]:
        head1, head2 = list1, list2
        head = tmp = ListNode()
        while head1 and head2:
            if head1.val < head2.val:
                tmp.next = head1
                tmp = tmp.next
                head1 = head1.next
            else:
                tmp.next = head2
                tmp = tmp.next
                head2 = head2.next

        if head1:
            tmp.next = head1
        
        if head2:
            tmp.next = head2

        return head.next
            
