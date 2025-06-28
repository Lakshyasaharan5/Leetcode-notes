class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        dp = [-1] * (target + 1)
        nums.sort()

        def backtrack(target):
            if target == 0:
                return 1            
            if target < 0:
                return 0
            if dp[target] != -1:
                return dp[target]

            curr = 0
            for i in range(len(nums)):
                if(target - nums[i] < 0): 
                    break
                curr += backtrack(target - nums[i])

            dp[target] = curr
            return dp[target]

        res = backtrack(target)
        return res 