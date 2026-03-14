class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        N = len(nums)
        res = [0] * N
        done = []
        st = []
        for i in range(2 * N - 1):
            idx = i % N
            while st and nums[st[-1]] < nums[idx]:
                top = st.pop()
                if top not in done:
                    res[top] = nums[idx]
                    done.append(top)
            st.append(idx)
        while st:
            top = st.pop()
            if top not in done:
                res[top] = -1
                done.append(top)
        return res

