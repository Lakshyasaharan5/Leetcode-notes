class Solution {

    private class Trie {
        Trie[] charArray = new Trie[26];
        boolean isEnd = false;
    }

    private void insert(Trie root, String word) {
        Trie curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.charArray[ch - 'a'] == null) {                           
                curr.charArray[ch - 'a'] = new Trie();
            }
            curr = curr.charArray[ch - 'a'];
        }
        curr.isEnd = true;        
    }

    private boolean match(Trie root, String word) {
        Trie curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.charArray[ch - 'a'] == null)
                return false;
            curr = curr.charArray[ch - 'a'];
        }
        return curr.isEnd;
    }

    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        for (String word : wordDict) {            
            insert(root, word);            
        }
        /**
                    acb
                    a,          ac,         acb
                   c,cb         b
                   b

               [a,ac,cb] 

               [a,0,c,0,0....]    
                |   \----------------\
               [0,0,c,.]              \
                    |            [0,b,0,0,0....]  
                   [0,0,0..]        \
                                    [0,0,0..], isEnd=true
        
         */
        dp = new Boolean[s.length()];
        return dfs(s, wordDict, 0, root);
    }

    private boolean dfs(String s, List<String> wd, int start, Trie root) {
        if (start >= s.length()) return true;
        if (dp[start] != null) return dp[start];
        for (int i=start; i < s.length(); i++) {
            String curr = s.substring(start,i + 1);
            if (match(root, curr)) {
                if (dfs(s, wd, i + 1, root))
                    return dp[start] = true;
            }
        }
        return dp[start] = false;
    }

    private boolean match(String curr, List<String> wd) {
        for (String w : wd)
            if (curr.equals(w))
                return true;
        return false;
    }
}