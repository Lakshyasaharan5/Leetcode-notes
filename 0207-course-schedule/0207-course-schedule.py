class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
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
        
        while q:
            front = q.popleft()
            for course in adj[front]:
                indegree[course] -= 1
                if indegree[course] == 0:
                    q.append(course)
            

        # return true or false
        for idg in indegree:
            if idg > 0:
                return False
        return True