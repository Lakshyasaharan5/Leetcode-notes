class Solution:
    def maxJumps(self, arr: List[int], d: int) -> int:
        n = len(arr)
        dp = [-1] * n

        def dfs(start, d):
            if dp[start] != -1:
                return dp[start]

            # go left
            i = start - 1
            left = d
            leftMax = -float('inf')
            while (i >= 0 and left > 0 and arr[i] < arr[start]):
                leftMax = max(leftMax, dfs(i, d))
                i -= 1
                left -= 1

            # go right
            i = start + 1
            right = d
            rightMax = -float('inf')
            while (i < len(arr) and right > 0 and arr[i] < arr[start]):
                rightMax = max(rightMax, dfs(i, d))
                i += 1
                right -= 1

            # return max(left, right) + 1
            if leftMax == float('-inf') and rightMax == float('-inf'):
                dp[start] = 1
            else:
                dp[start] = max(leftMax, rightMax) + 1

            return dp[start]

        for i in range(n):
            dfs(i, d)

        return max(dp)