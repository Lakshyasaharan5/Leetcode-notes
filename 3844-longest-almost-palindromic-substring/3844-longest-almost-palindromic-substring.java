class Solution {
    public int almostPalindromic(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] left = new int[2];
            int[] right = new int[2];
            //odd
            int[] lr = expand(s, i, i);
            longest = Math.max(longest, lr[1] - lr[0] - 1);
            if (lr[0] >= 0 || lr[1] < s.length()){
                left = expand(s, lr[0] - 1, lr[1]);
                right = expand(s, lr[0], lr[1] + 1);
                longest = Math.max(longest, Math.max(left[1] - left[0] - 1, right[1] - right[0] - 1));
            }
            
            //even
            lr = expand(s, i, i + 1);
            longest = Math.max(longest, lr[1] - lr[0] - 1);
            if (lr[0] >= 0 || lr[1] < s.length()){
                left = expand(s, lr[0] - 1, lr[1]);
                right = expand(s, lr[0], lr[1] + 1);
                longest = Math.max(longest, Math.max(left[1] - left[0] - 1, right[1] - right[0] - 1));
            }
        }
        return longest;
    }

    private int[] expand(String s, int l, int r) {
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[]{l, r};
    }
}