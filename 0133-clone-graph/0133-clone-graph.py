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

        # bfs and fill gmap
        q = deque()
        visited = set()
        q.append(node)
        visited.add(node)
        while q:
            front = q.popleft()
            gmap[front] = Node(front.val, [])
            for nb in front.neighbors:
                if nb not in visited:
                    q.append(nb)
                    visited.add(nb)
        
        # make adjacency list from gmap
        for original, new in gmap.items():
            for nb in original.neighbors:
                new.neighbors.append(gmap[nb])

        return gmap[node]
        