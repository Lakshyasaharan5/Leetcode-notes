class Solution {
    /**
            text    = ab
            pattern = ab

            _ a _ b _

            a b d c d b c     aaaaa xxxxx ccccccc
            1 1 1 1 1 1 1
            0 0 0 1 1 1 2

            aaaa xxx aaa xxx ccc xxx aaa xxx ccc

            p[0] .. 

     */
    public long maximumSubsequenceCount(String text, String pattern) {
        int p0 = 1;
        long left = 0;
        for (char ch : text.toCharArray()) {
            if (ch == pattern.charAt(1)) {
                left += p0;
            }
            if (ch == pattern.charAt(0)) {
                p0++;
            }
        }
        int p1 = 1;
        long right = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            char ch = text.charAt(i);
            if (ch == pattern.charAt(0)) {
                right += p1;
            }
            if (ch == pattern.charAt(1)) {
                p1++;
            }
        }
        return Math.max(left, right);
    }
}