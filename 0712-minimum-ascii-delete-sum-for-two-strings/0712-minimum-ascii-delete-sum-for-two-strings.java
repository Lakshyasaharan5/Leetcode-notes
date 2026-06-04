class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp = new Integer[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, 0, 0);
    }

    private int dfs(String s1, String s2, int i, int j) {
        if (i >= s1.length() && j >= s2.length()) return 0;
        if (dp[i][j] != null) return dp[i][j];
        if (i >= s1.length()) {
            int asciiValue = 0;
            for (char ch : s2.substring(j).toCharArray()) {
                asciiValue += ascii(ch);
            }
            return asciiValue;
        }
        if (j >= s2.length()) {
            int asciiValue = 0;
            for (char ch : s1.substring(i).toCharArray()) {
                asciiValue += ascii(ch);
            }
            return asciiValue;
        }        
        int l = Integer.MAX_VALUE, c = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j)) {
            c = dfs(s1, s2, i + 1, j + 1);
        } else {
            l = dfs(s1, s2, i + 1, j) + ascii(s1.charAt(i));
            r = dfs(s1, s2, i, j + 1) + ascii(s2.charAt(j));
        }

        return dp[i][j] = Math.min(Math.min(l, r), c);
    }

    private int ascii(char ch) {
        return (int)ch;
    }
}