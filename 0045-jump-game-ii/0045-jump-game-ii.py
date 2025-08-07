class Solution:
    def jump(self, nums: List[int]) -> int:
        dp = {}
        def dfs(start):  
            if start in dp:
                return dp[start]          
            if start >= len(nums) - 1:
                return 0
            if nums[start] == 0:
                return float('inf')
            jumps = float('inf')
            for i in range(1, nums[start] + 1):                
                jumps = min(jumps, dfs(start + i))
            dp[start] = jumps + 1
            return jumps + 1

        return dfs(0) 