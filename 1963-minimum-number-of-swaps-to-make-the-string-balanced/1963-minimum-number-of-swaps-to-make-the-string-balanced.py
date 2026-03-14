class Solution:
    def minSwaps(self, s: str) -> int:
        """
        ]]][[[        
        """
        st = []
        swaps = 0
        for bkt in s:
            if bkt == ']':
                if len(st) > 0 and st[-1] == '[':
                    st.pop()
                else:
                    st.append('[')
                    swaps += 1
            else:
                st.append('[')
        return swaps