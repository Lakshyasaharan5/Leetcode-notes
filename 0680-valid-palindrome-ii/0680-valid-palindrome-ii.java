class Solution {
    public boolean validPalindrome(String s) {
        // d a e a
        // l
        //       r
        // a d a e a
        // l
        //         r
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (check(l+1, r, s) || check(l, r-1, s)) return true;
                return false;
            }else {
                l++;
                r--;
            }
        }
        return true;
    }

    private boolean check(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}