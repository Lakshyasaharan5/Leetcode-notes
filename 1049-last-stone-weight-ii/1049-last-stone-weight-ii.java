class Solution {
    Map<String, Integer> dp;
    public int lastStoneWeightII(int[] stones) {
        dp = new HashMap<>();
        return dfs(stones, 0, 0);
    }

    private int dfs(int[] stones, int start, int curr) {
        String key = start + "-" + curr;
        if (start == stones.length) {
            if (curr < 0)
                return Integer.MAX_VALUE;
            return curr;
        }
        if (dp.containsKey(key)) return dp.get(key);
        int res = Math.min(dfs(stones, start + 1, curr + stones[start]), dfs(stones, start + 1, curr - stones[start]));
        dp.put(key, res);
        return res;
    }
}