# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flipEquiv(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        # without flip
        without = self.flipEquiv(p.left, q.left) and self.flipEquiv(p.right, q.right)
        # with flip
        flip = self.flipEquiv(p.left, q.right) and self.flipEquiv(p.right, q.left)
        return p.val == q.val and (flip or without)