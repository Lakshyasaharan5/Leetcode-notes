class Solution:
    def reverseParentheses(self, s: str) -> str:
        """
         1         1
            2
                3
        (ed(et(oc))el)

        ((a(bc)(de)fg(h)))
        (acbedfgh)
        hgfdebca      
        """
        st = []

        def reverse(st):
            buffer = ""
            while st[-1] != '(':
                buffer += st.pop()
            st.pop()
            for b in buffer:
                st.append(b)

        for ch in s:
            if ch == ')':
                reverse(st)
            else:
                st.append(ch)

        return "".join(st)