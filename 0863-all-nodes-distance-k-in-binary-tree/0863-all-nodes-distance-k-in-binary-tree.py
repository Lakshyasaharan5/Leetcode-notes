# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        adj = {}
        def traverse(node, parent):
            if not node:
                return
            if node not in adj:
                adj[node] = []
            if parent:
                adj[node].append(parent)
                if parent not in adj:
                    adj[parent] = []
                adj[parent].append(node)
            traverse(node.left, node)
            traverse(node.right, node)
        traverse(root, None)
        visited = {target}
        que = deque([target])
        while que and k > 0:
            for _ in range(len(que)):
                front = que.popleft()
                for nb in adj[front]:
                    if nb not in visited:
                        que.append(nb)
                        visited.add(nb)
            k -= 1
        res = []
        while que:
            res.append(que.popleft().val)
        return res
        
        
