class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # create graph using adjacency list and indegree array
        adj = defaultdict(list)
        indegree = [0] * numCourses
        for course, pre in prerequisites:
            adj[pre].append(course)
            indegree[course] += 1                

        # bfs
        q = deque()
        for course in range(numCourses):
            if indegree[course] == 0:
                q.append(course)
        
        order = []
        while q:
            front = q.popleft()
            order.append(front)
            for course in adj[front]:
                indegree[course] -= 1
                if indegree[course] == 0:
                    q.append(course)
            

        # return true or false
        if len(order) < numCourses:
            return []
        return order