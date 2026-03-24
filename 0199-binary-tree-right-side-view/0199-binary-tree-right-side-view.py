# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q = deque()
        rightSide = []
        q.append(root)
        while q:
            rightSide.append(q[-1].val)
            currSize = len(q)
            for _ in range(currSize):
                front = q.popleft()
                if front.left:
                    q.append(front.left)
                if front.right:
                    q.append(front.right)
        return rightSide