# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        resPaths = []
        self.dfs(root, targetSum, [], resPaths)
        return resPaths
        
    def dfs(self, root, targetSum, currPath, resPaths):
        if not root:
            return         

        currPath.append(root.val)
        if not root.left and not root.right and targetSum - root.val == 0:
            resPaths.append(copy.deepcopy(currPath))            
        
        self.dfs(root.left, targetSum - root.val, currPath, resPaths)
        self.dfs(root.right, targetSum - root.val, currPath, resPaths)
        currPath.pop()