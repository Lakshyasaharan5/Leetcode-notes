class Solution:
    def compress(self, chars: List[str]) -> int:
        ptr = 0
        i = 0
        while i < len(chars):
            j = i
            while j < len(chars) and chars[j] == chars[i]: 
                j += 1
            chars[ptr] = chars[i]
            ptr += 1
            if (j - i) > 1:
                for d in str(j - i):
                    chars[ptr] = d
                    ptr += 1
            i = j

        return ptr 