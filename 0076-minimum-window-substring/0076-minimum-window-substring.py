class Solution:
    def minWindow(self, s: str, t: str) -> str: 
        if len(t) > len(s): return ""      
        freq = [0] * 256
        for ch in t:
            freq[ord(ch)] += 1
        cnt = len(t)
        left, right = 0, 0
        minLen, idx = float("inf"), 0
        while right < len(s):
            if freq[ord(s[right])] > 0:
                cnt -= 1
            freq[ord(s[right])] -= 1            
            while cnt == 0:
                if right - left + 1 < minLen:
                    minLen = right - left + 1
                    idx = left
                freq[ord(s[left])] += 1
                if(freq[ord(s[left])] > 0):
                    cnt += 1
                left += 1
            right += 1
        return s[idx : idx+minLen] if minLen < float('inf') else ""
            
        
