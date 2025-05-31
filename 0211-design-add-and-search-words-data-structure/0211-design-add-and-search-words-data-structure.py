class TrieNode:
    def __init__(self):
        self.arr = [None] * 26
        self.isEnd = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        curr = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if not curr.arr[idx]:
                curr.arr[idx] = TrieNode()
            curr = curr.arr[idx]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        def dfs(word, idx, curr):
            if idx == len(word):
                return curr.isEnd
            c = word[idx]
            if c == '.':
                for each in curr.arr:
                    if each:
                        if(dfs(word, idx+1, each)):
                            return True
                return False
            asci = ord(c) - ord('a')
            if curr.arr[asci] is None:
                return False
            curr = curr.arr[asci]
            return dfs(word, idx+1, curr)
        
        return dfs(word, 0, self.root)

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)

"""
b..
..b
b.a.n
"""