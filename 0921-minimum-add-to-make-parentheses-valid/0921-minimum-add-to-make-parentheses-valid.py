class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        st = []
        for p in s:
            if p == ')':
                if len(st) > 0 and st[-1] == '(':
                    st.pop() 
                else:
                    st.append(p)                                   
            else:
                st.append(p)

        return len(st)