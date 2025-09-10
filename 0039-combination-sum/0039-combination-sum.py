class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def dfs(curr, target, start):
            if target <= 0: 
                if target == 0: res.append(curr[:])
                return
            for i in range(start, len(candidates)):
                curr.append(candidates[i])
                dfs(curr, target - candidates[i], i)
                curr.pop()

        dfs([], target, 0)
        return res
            
        


        