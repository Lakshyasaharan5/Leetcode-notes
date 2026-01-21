class Solution {
    public int findTheLongestSubstring(String s) {
        // e l e e t m i n i c o w o r o e p
        // ^

        // aeiou
        // 01010
        String vowels = "aeiou";
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        int mask = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowels.indexOf(ch) >= 0) mask ^= 1 << vowels.indexOf(ch);
            if (!seen.containsKey(mask)) seen.put(mask, i);
            res = Math.max(res, i - seen.get(mask));
        }        
        return res;
    }
}