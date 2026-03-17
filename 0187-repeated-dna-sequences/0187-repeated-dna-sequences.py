class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        seen = set()
        added = set()
        res = []
        mpp = {
            'A': 0,
            'C': 1,
            'G': 2,
            'T': 3
        }
        hsh = 0
        for i in range(len(s)):
            hsh <<= 2
            hsh |= mpp[s[i]]
            hsh &= (1 << 20) - 1
            if (i < 9):
                continue
            if (hsh in seen):
                if (hsh not in added):
                    added.add(hsh)
                    res.append(s[i - 9 : i + 1])
            seen.add(hsh)            

        return res