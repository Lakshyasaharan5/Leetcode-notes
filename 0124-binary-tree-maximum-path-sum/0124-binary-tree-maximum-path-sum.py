# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxSum = -float('inf')
        def dfs(root) -> int:
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            self.maxSum = max(self.maxSum, left + root.val, right + root.val, root.val + left + right, root.val)
            return max(max(left, right) + root.val, root.val)
        dfs(root)
        return self.maxSum