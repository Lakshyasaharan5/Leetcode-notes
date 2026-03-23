# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        st = []   
        st.append(root)    
        while st:
            top = st.pop()
            while top:
                st.append(top)
                top = top.left
            k -= 1
            curr = st.pop()
            if k == 0:
                return curr.val             
            if curr.right:
                st.append(curr.right)
            else:
                st.append(None)