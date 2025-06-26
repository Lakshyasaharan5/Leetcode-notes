class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res, tmp = [], []
        candidates.sort()

        def backtrack(candidates, target, idx, curr_sum):
            if curr_sum == target:
                res.append(copy.deepcopy(tmp))
                return
            
            if curr_sum > target or idx == len(candidates):
                return

            for i in range(idx, len(candidates)):
                if(i>idx and candidates[i] == candidates[i-1]):
                    continue
                tmp.append(candidates[i])
                backtrack(candidates, target, i+1, curr_sum+candidates[i])
                tmp.pop()

        backtrack(candidates, target, 0, 0)
        
        return res 











