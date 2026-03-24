# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.symmetric = True
        self.dfs(root, root)
        return self.symmetric
        
    def dfs(self, p, q):
        if not p and not q:            
            return 
        if (not p or not q) or (p.val != q.val):
            self.symmetric = False 
            return       
        self.dfs(p.left, q.right)    
        self.dfs(p.right, q.left)    