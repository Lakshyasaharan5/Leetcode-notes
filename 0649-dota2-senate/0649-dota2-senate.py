class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        dq = deque()    
        R, D = 0, 0    
        for s in senate:
            if s == 'R':
                R += 1
            else:
                D += 1
            dq.append(s)
        ban_R, ban_D = 0, 0
        while len(dq) > 1 and R > 0 and D > 0:
            front = dq.popleft()            
            if front == 'R':
                if ban_R > 0:
                    R -= 1
                    ban_R -= 1
                else:
                    ban_D += 1
                    dq.append(front)
            else:
                if ban_D > 0:
                    D -= 1
                    ban_D -= 1
                else:
                    ban_R += 1
                    dq.append(front)
        
        return "Radiant" if dq[0] == 'R' else "Dire"