class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) < len(p): 
            return []
        freq_s = [0] * 26
        freq_p = [0] * 26
        for i in range(len(p)):
            freq_s[ord(s[i]) - ord('a')] += 1
            freq_p[ord(p[i]) - ord('a')] += 1
        
        res = []
        if (self._isAnagram(freq_s, freq_p)):
            res.append(0)
        for i in range(len(p), len(s)):
            freq_s[ord(s[i - len(p)]) - ord('a')] -= 1
            freq_s[ord(s[i]) - ord('a')] += 1
            if (self._isAnagram(freq_s, freq_p)):
                res.append(i - len(p) + 1)
        return res

    def _isAnagram(self, freq_s: list[int], freq_p: list[int]) -> bool:
        for i in range(26):
            if freq_s[i] != freq_p[i]:
                return False
        return True