class Solution:
    def isPalindrome(self, s: str) -> bool:
        def alphaNum(c):
            return ("A" <= c <= "Z") or ("a" <= c <= "z") or ("0" <= c <= "9")

        def lower(c):
            if "A" <= c <= "Z":
                return chr(ord(c) + 32)
            return c

        l, r = 0, len(s) - 1
        while l < r:
            while l < r and not alphaNum(s[l]):
                l += 1
            while l < r and not alphaNum(s[r]):
                r -= 1
            if lower(s[l]) != lower(s[r]):
                return False
            l += 1
            r -= 1
            
        return True
