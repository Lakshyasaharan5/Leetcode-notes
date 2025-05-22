class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        curr = []

        def dfs(candidates, target, idx, currSum):
            if currSum > target:
                return
            if currSum == target:
                res.append(copy.deepcopy(curr))
                return

            for i in range(idx, len(candidates)):
                curr.append(candidates[i])
                dfs(candidates, target, i, currSum+candidates[i])
                curr.pop()

        dfs(candidates, target, 0, 0)
        return res
