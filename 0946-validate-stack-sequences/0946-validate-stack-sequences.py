class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        """
        pushed = [1,2,3,4,5]
                            i
        st = [1,2,3,4,5]

        popped = [5,4,3,2,1]
                             j
        """
        st = []
        i, j = 0, 0
        while i < len(pushed) and j < len(popped):
            if len(st) > 0 and st[-1] == popped[j]:
                st.pop()
                j += 1
            else:
                st.append(pushed[i])
                i += 1
        
        while j < len(popped):
            if len(st) > 0 and st[-1] == popped[j]:
                st.pop()
                j += 1
            else:
                break

        return True if len(st) == 0 else False
        