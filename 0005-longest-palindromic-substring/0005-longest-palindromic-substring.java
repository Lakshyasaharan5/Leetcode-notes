class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int max_l = 0, max_r = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    max_l = l;
                    max_r = r;
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }
            l = i; r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    max_l = l;
                    max_r = r;
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }
        }        
        return s.substring(max_l, max_r + 1);
    }
}