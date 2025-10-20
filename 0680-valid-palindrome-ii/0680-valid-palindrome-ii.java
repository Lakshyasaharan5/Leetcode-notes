class Solution {
    public boolean validPalindrome(String s) {
        // a b d d c c a
        //     l
        //           r
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return checkPalindrome(s, l+1, r) || checkPalindrome(s, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}

