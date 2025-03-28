"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        """
        [[3,null],[3,0],[3,null]]
        [3,null]->[3,null]->[3,null]
        0 : [3,null]
        1 : [3,null]
        2 : [3,null]
        """
        if head is None:
            return None
        
        # Create a new list
        prev = Node(head.val)
        newHead = prev
        curr = head.next
        while curr:
            prev.next = Node(curr.val)
            prev = prev.next
            curr = curr.next

        # Put new list in map based on index as keys
        # Put original list also in map but index as values
        index = {}
        tmp = newHead
        curr = head
        idx = 0
        while tmp:
            index[idx] = tmp
            index[curr] = idx
            idx += 1
            tmp = tmp.next
            curr = curr.next

        curr = head
        tmp = newHead
        while curr:
            if curr.random is None:
                pass
            else:
                tmp.random = index[index[curr.random]]
            curr = curr.next
            tmp = tmp.next

        return newHead

        
