class Solution:
    def minJumps(self, arr: List[int]) -> int:
        # create hastable for index
        index_map = {}
        for i in range(len(arr)):
            if arr[i] in index_map:
                index_map[arr[i]].append(i)
            else:
                index_map[arr[i]] = [i]

        # apply bfs
        queue = deque([0])
        min_jumps = 0
        visited = set([0])
        while queue:
            curr_size = len(queue)            
            for _ in range(curr_size):                
                curr = queue.popleft()
                if curr == len(arr) - 1: return min_jumps
                # right
                if curr + 1 < len(arr) and (curr + 1) not in visited:
                    queue.append(curr + 1)
                    visited.add(curr + 1)
                # left
                if curr - 1 >= 0 and (curr - 1) not in visited:
                    queue.append(curr - 1)  
                    visited.add(curr - 1)                          
                # index
                if arr[curr] in index_map:
                    for idx in range(len(index_map[arr[curr]]) - 1, -1, -1):
                        if index_map[arr[curr]][idx] not in visited:
                            queue.append(index_map[arr[curr]][idx])
                            visited.add(index_map[arr[curr]][idx])
                    del index_map[arr[curr]]
            min_jumps += 1

        return min_jumps