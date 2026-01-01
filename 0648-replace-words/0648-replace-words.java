class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }
        String[] sentenceArray = sentence.split(" ");
        int idx = 0;
        for (String sen : sentenceArray) {
            sentenceArray[idx++] = trie.getRootWord(sen);
        }

        return String.join(" ", sentenceArray);
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26]; // a-z
    boolean isEndOfWord = false;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    // Search exact word
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

    // Prefix search
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }

    public String getRootWord(String derivative) {
        TrieNode node = root;
        StringBuilder rootWord = new StringBuilder();
        for (char c : derivative.toCharArray()) {
            rootWord.append(c);
            int idx = c - 'a';  
            if (node.children[idx] == null) return derivative;                  
            if (node.children[idx].isEndOfWord) return rootWord.toString();            
            node = node.children[idx];
        }

        return derivative;
    }
}
