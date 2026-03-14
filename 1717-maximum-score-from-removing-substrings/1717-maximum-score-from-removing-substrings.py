class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        st = []
        gain = 0
        if x > y:
            for ch in s:
                if ch == 'b' and st and st[-1] == 'a':
                    st.pop()
                    gain += x
                else:
                    st.append(ch)
            s = "".join(st)            
            st = []
            for ch in s:
                if ch == 'a' and st and st[-1] == 'b':
                    st.pop()
                    gain += y
                else:
                    st.append(ch)
        else:
            for ch in s:
                if ch == 'a' and st and st[-1] == 'b':
                    st.pop()
                    gain += y
                else:
                    st.append(ch)
            s = ""
            s = "".join(st)            
            st = []
            for ch in s:
                if ch == 'b' and st and st[-1] == 'a':
                    st.pop()
                    gain += x
                else:
                    st.append(ch)
     
        return gain