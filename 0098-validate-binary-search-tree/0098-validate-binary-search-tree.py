# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = float('-inf')
        self.bst = True
        def dfs(root):
            if not root:
                return
            dfs(root.left)
            if (root.val <= self.prev):
                self.bst = False
            if not self.bst:
                return
            self.prev = root.val
            dfs(root.right)
        dfs(root)
        return self.bst