class Solution:
    def smallestNumber(self, arrival_pattern: str) -> str:
        st = []
        cnt = 0
        res = [0] * (len(arrival_pattern) + 1)
        for idx, order in enumerate(arrival_pattern):
            if order == 'I':
                cnt += 1
                res[idx] = cnt
                while len(st) != 0:
                    cnt += 1
                    res[st.pop()] = cnt
            else:
                st.append(idx)

        cnt += 1
        res[-1] = cnt    
        while len(st) != 0:
            cnt += 1
            res[st.pop()] = cnt
        
        guest_order = ""
        for r in res:
            guest_order += str(r)
        return guest_order