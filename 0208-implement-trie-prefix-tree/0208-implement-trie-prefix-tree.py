"""
Create a class node (node[], isEnd)

a p p l e

insert function:
    - Iterate each char of word checking if present
    - If not then create new node and insert

search function:
    - Iterate each char of word checking if present
    - Check if we reached the isEnd otherwise return false

startsWith:
    - Almost same as search, not dependent on isEnd
"""
class Node:
    def __init__(self):
        self.arr = [None] * 26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if curr.arr[idx] is None:
               curr.arr[idx] = Node()
            curr = curr.arr[idx]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if curr.arr[idx] is None:
                return False
            curr = curr.arr[idx]
        return True if curr.isEnd else False

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            idx = ord(c) - ord('a')
            if curr.arr[idx] is None:
                return False
            curr = curr.arr[idx]
        return True 


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)