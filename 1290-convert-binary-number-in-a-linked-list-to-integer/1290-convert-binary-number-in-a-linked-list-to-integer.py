# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        result = []
        temp = head
        while temp!=None:
            result.append(str(temp.val))
            temp = temp.next
            
        return int(''.join(result), 2)