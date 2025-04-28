class Solution:
    def isValid(self, s: str) -> bool:
        map = {'(':')', '[':']', '{':'}'}
        stack = []
        for p in s:
            if p in map:
                stack.append(p)
            else:
                if len(stack) == 0 or map[stack.pop()] != p:
                    return False
        return True if len(stack) == 0 else False