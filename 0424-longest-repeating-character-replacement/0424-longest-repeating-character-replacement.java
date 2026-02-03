class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int longest = 0;
        int[] freq = new int[26];
        int maxFreq = 0, chars = 0;
        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++;
            chars++;
            for (int i = 0; i < 26; i++) maxFreq = Math.max(maxFreq, freq[i]);
            while (chars - maxFreq > k) {                
                freq[s.charAt(l++) - 'A']--;
                chars--;                
                for (int i = 0; i < 26; i++) maxFreq = Math.max(maxFreq, freq[i]);
            }
            longest = Math.max(longest, r - l + 1);
            r++;
        }
        return longest;
    }
}