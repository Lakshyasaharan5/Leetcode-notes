class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        
        def dfs(start):
            if start < 0 or start >= len(arr) or arr[start] < 0: return False
            arr[start] *= -1
            if arr[start] == 0: return True
            return dfs(start - arr[start]) or dfs(start + arr[start])

        return dfs(start)