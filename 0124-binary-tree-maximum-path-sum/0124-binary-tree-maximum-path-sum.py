# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = [-1001]

        def dfs(root):
            if not root: return 0
            left_max_sum = dfs(root.left)
            right_max_sum = dfs(root.right)
            res[0] = max(res[0], root.val, root.val + left_max_sum + right_max_sum, root.val + left_max_sum, root.val + right_max_sum)
            return max(max(left_max_sum, right_max_sum) + root.val, root.val)
        
        dfs(root)
        return res[0]