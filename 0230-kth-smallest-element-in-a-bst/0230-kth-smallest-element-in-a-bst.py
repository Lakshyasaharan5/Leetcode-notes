# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res = [0]
        flag = [k]

        def dfs(root):
            if not root:
                return            
            dfs(root.left)
            flag[0] -= 1
            if flag[0] == 0:
                res[0] = root.val
                return
            dfs(root.right)

        dfs(root)

        return res[0]