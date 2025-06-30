"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None

        gmap = {}
        res = Node(node.val)
        gmap[node.val] = res
        def bfs(node):
            visited = []
            q = deque([node])
            visited.append(node)
            while q:
                curr = q.popleft()                                
                curr_clone = gmap[curr.val]
                for n in curr.neighbors:
                    if n in visited:
                        curr_clone.neighbors.append(gmap[n.val])
                        continue
                    new_node = Node(n.val)
                    curr_clone.neighbors.append(new_node)
                    gmap[new_node.val] = new_node
                    visited.append(n)
                    q.append(n)

        
        bfs(node)
        return res