class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        """
        ()
        ( -> push 0 push 0.5
        ) -> pop + (pop + pop)
        st = [0.5, 0, 0.5]
        """        
        st = [0.5]        
        for p in s:
            if p == '(':
                st.append(0)
                st.append(0.5)
            else:
                st.append(int(st.pop() * 2 + st.pop() + st.pop()))
        return st[-1]