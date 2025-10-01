class Solution {    
    HashMap<Integer, Integer> dp = new HashMap<>();
    public int numDecodings(String s) {                
        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (i == s.length() - 1) return 1;        
        if (dp.containsKey(i)) return dp.get(i);
        int res = dfs(s, i+1) + (isValid(Integer.parseInt(s.substring(i, i+2))) ? dfs(s, i+2) : 0);        
        dp.put(i, res);
        return dp.get(i);
    }

    private boolean isValid(int num) {
        return num > 0 && num <= 26;
    }
}