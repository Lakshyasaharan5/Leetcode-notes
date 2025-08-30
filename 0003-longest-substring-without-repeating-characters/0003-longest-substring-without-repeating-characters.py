class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # p w w k e w
        #       i
        #           j
        freq = {}
        i, j = 0, 0
        maxLen = 0
        while j < len(s):
            if s[j] in freq and freq[s[j]] >= i:
                i = freq[s[j]] + 1
            else:
                freq[s[j]] = j
                maxLen = max(maxLen, j - i + 1)
                j += 1

        return maxLen
            
                