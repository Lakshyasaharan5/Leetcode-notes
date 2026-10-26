class Solution {
    /**
        b a b a d
        i  
                j
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res = expand(s, i, i, res);
            res = expand(s, i, i + 1, res);
        }
        return res;
    }

    private String expand(String s, int i, int j, String res) {        
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if (j - i + 1 > res.length()) {
                res = s.substring(i, j + 1);
            }
            i--;
            j++;
        }  
        return res;      
    }
}