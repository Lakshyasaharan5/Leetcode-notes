class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(candidates, target, i, subset, currSum):
            if i == len(candidates) or currSum >= target:
                if currSum == target:
                    res.append(subset.copy())
                return
            subset.append(candidates[i])
            dfs(candidates, target, i, subset, currSum+candidates[i])
            subset.pop()
            dfs(candidates, target, i+1, subset, currSum)

        dfs(candidates, target, 0, [], 0)
        return res