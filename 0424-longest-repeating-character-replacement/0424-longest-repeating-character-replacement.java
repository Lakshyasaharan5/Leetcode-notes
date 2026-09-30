class Solution {
    /**
        "AABABBA", k = 1
         -----

         AAAABBBBB     k=2
          i
               j 
         A:3
         B:3
         C:

         
         while (j - i + 1 - getMax(freqMap) > k)
            i++
        res = max(j - i + 1 - getMax(freqMap))


     */
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int res = Integer.MIN_VALUE;
        while (j < s.length()) {
            char curr = s.charAt(j);
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
            while (j - i + 1 - getMax(freq) > k) {
                char prev = s.charAt(i);
                freq.put(prev, freq.get(prev) - 1);
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }

    private int getMax(Map<Character, Integer> freq) {
        int maxFreq = 0;
        for (int value : freq.values()) {
            maxFreq = Math.max(maxFreq, value);
        }
        return maxFreq;
    }
}