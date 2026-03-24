# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        view = [0] * self.depth(root)
        def dfs(root, level):
            if not root:
                return
            view[level] = root.val
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
        dfs(root, 0)
        return view
    def depth(self, root):
        if not root:
            return 0
        return max(self.depth(root.left), self.depth(root.right)) + 1