class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(candidates, target, subset, i):
            if target <= 0:
                if target == 0:
                    res.append(subset.copy())
                return
            prev = 0
            for j in range(i, len(candidates)):
                if prev == candidates[j]:
                    continue                
                subset.append(candidates[j])
                dfs(candidates, target-candidates[j], subset, j+1)
                subset.pop()
                prev = candidates[j]
                
        dfs(sorted(candidates), target, [], 0)
        return res