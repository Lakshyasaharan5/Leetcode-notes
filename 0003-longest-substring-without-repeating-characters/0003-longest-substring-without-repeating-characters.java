class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int l = 0, r = 0;
        int longest = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (indexMap.containsKey(ch) && indexMap.get(ch) >= l) {
                l = indexMap.get(ch) + 1;
                indexMap.put(ch, r);
            } else {
                indexMap.put(ch, r);
            }
            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;
    }
}