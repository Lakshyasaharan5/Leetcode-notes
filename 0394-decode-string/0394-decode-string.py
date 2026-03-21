class Solution:
    def decodeString(self, s: str) -> str:
        """
        
        """
        st = []
        for ch in s:
            if ch == ']':
                letters = ""
                number = ""
                # letters
                while st and st[-1] != '[':
                    letters += st.pop()
                letters = letters[::-1]
                st.pop() # remove [
                # number
                while st and '0' <= st[-1] <= '9':
                    number += st.pop()
                number = int(number[::-1])
                for c in (letters * number):
                    st.append(c)
            else:
                st.append(ch)
                
        return "".join(st)