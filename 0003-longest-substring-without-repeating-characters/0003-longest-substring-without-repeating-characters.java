class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 0 1 2 3 4 5 6 7
        // a b c b b c b b
        // l
        // r
        // a:0, b:4, c:2
        HashMap<Character, Integer> mapIndex = new HashMap<>();
        int maxLen = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            char curr = s.charAt(r);
            if (mapIndex.containsKey(curr) && mapIndex.get(curr) >= l) {
                l = mapIndex.get(curr) + 1;
            }
            mapIndex.put(curr, r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}