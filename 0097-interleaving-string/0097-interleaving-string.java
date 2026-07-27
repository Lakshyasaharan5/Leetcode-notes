class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        /*
            if i == len
                s[j:] == s[k:]
            if j == len
                s[i:] == s[k:]
            if i == j
                dfs(i+1) or dfs(j+1)
            if i == s[k]
                dfs(i+1)            
            dfs(j+1)

            s1 = "abdc"
                      i  
            s2 = "bacd"
                      j
            s3 = "ababcdcd"
                        k = i + j
                (0,0)
                (1,0)
            /           \
           (2,0)        (1,1)
        */
        dp = new Boolean[s1.length()][s2.length()];
        return dfs(s1, s2, 0, 0, s3);
    }

    private boolean dfs(String a, String b, int i, int j, String c) {
        int k = i + j;
        if (i == a.length()) {            
            while (j < b.length()) {
                if (b.charAt(j) != c.charAt(k))
                    return false;
                j++;
                k++;
            }
            return true;
        }
        if (j == b.length()) {
            while (i < a.length()) {
                if (a.charAt(i) != c.charAt(k))
                    return false;
                i++;
                k++;
            }
            return true;
        }
        if (dp[i][j] != null) return dp[i][j];
        if (a.charAt(i) == b.charAt(j) && a.charAt(i) == c.charAt(k)) {
            return dp[i][j] = dfs(a, b, i + 1, j, c) || dfs(a, b, i, j + 1, c);
        }
        if (a.charAt(i) == c.charAt(k)) {
            return dp[i][j] = dfs(a, b, i + 1, j, c);
        }
        if (b.charAt(j) == c.charAt(k)) {
            return dp[i][j] = dfs(a, b, i, j + 1, c);
        }
        return false;
    }
}