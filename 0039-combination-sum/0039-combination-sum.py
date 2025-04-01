class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(candidates, target, i, comb, currSum):
            if currSum >= target:
                if currSum == target:
                    res.append(comb.copy())
                return
            for j in range(i, len(candidates)):
                comb.append(candidates[j])
                dfs(candidates, target, j, comb, currSum + candidates[j])
                comb.pop()

        dfs(candidates, target, 0, [], 0)
        return res

