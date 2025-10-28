class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, 0, dp);
    }

    private int dfs(String s, int start, int[] dp) {
        if (start >= s.length()) return -1;
        if (dp[start] != -1) return dp[start];
        int currMin = 2001;
        for (int i = start; i < s.length(); i++) {
            String curr = s.substring(start, i + 1);
            if (!isPalindrome(curr)) continue;
            currMin = Math.min(currMin, dfs(s, i + 1, dp));
        }
        return dp[start] = currMin + 1;
    }

    private boolean isPalindrome(String s){
        int l=0, r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }    
}