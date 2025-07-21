class Solution:
    def longestPalindrome(self, s: str) -> str:
        longest = 1
        res = ""

        def expand(s, l, r):
            palindrome = ""
            while l >= 0 and r < len(s) and s[l] == s[r]:
                palindrome = s[l:r+1]
                l -= 1
                r += 1
            return palindrome

        for i in range(len(s)):
            even = expand(s, i, i + 1)
            odd = expand(s, i, i)
            if len(even) >= longest:
                res = even
                longest = len(even)

            if len(odd) >= longest:
                res = odd
                longest = len(odd)

        return res
