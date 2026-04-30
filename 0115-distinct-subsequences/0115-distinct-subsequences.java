class Solution {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<t.length(); j++){
                dp[i][j]=-1;
            }
        }
         return helper(s, t, 0, 0, dp);
    }

    public int helper(String s, String t, int i, int j, int[][] dp){
        if(j==t.length()){            
            return 1;
        }
        if(i==s.length())return 0;

        if(dp[i][j]>=0)return dp[i][j];

        int a=0, b=0;
        if(s.charAt(i)==t.charAt(j))
            a = helper(s,t, i+1, j+1, dp);

        b = helper(s,t, i+1, j, dp);

        return dp[i][j]=a+b;
        
    }
}