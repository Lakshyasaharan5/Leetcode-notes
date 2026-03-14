class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        mpp = {}
        st = []
        for n in nums2:
            while st and st[-1] < n:
                mpp[st.pop()] = n
            st.append(n) 
        while st:
            mpp[st.pop()] = -1       
        
        res = [-1] * len(nums1)
        for i, n in enumerate(nums1):
            res[i] = mpp[n]

        return res