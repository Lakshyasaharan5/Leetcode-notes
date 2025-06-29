class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        if len(words) == 1:
            return True
        
        dictionary = {}
        cnt = 1
        for char in order:
            dictionary[char] = cnt
            cnt += 1

        def is_valid(w1, w2):
            i,j = 0,0
            while i < len(w1) and j < len(w2):
                if(dictionary[w1[i]] < dictionary[w2[j]]):
                    return True
                if(dictionary[w1[i]] > dictionary[w2[j]]):
                    return False
                i += 1
                j += 1
            
            if(i < len(w1)):
                return False

            return True

        for i in range(1, len(words)):
            if not is_valid(words[i-1], words[i]):
                return False

        return True
