class Solution:
    def minWindow(self, s: str, t: str) -> str:
        """
        ADOBECODEBANC
                 i
                    j

        A : 0
        B : 1
        C : 0
        allDone = 1
        """
        if len(s) < len(t):
            return ""
        find = {}
        for i in t:
            if i in find:
                find[i] += 1
            else:
                find[i] = 1

        allDone = len(set(t))
        result = []
        minWindow = float("inf")
        i, j = 0, 0
        while j < len(s):
            if s[j] in find:
                find[s[j]] -= 1
                if find[s[j]] == 0:
                    allDone -= 1
                while allDone == 0 and i <= j:
                    if j - i + 1 < minWindow:
                        result = [i, j]
                        minWindow = j - i + 1
                    if s[i] in find:
                        find[s[i]] += 1
                        if find[s[i]] > 0:
                            allDone += 1
                    i += 1
            j += 1

        return s[result[0]: result[1] + 1] if len(result) > 0 else ""

