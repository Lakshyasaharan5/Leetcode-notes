class Solution {
    public int minFlips(String s) {
        int n = s.length();
        StringBuilder sb_one = new StringBuilder();
        StringBuilder sb_zero = new StringBuilder();
        boolean flip = false;
        for (int i = 0; i < 2 * n; i++) {
            if (flip) {
                sb_one.append("0");
                sb_zero.append("1");
            } else {
                sb_one.append("1");
                sb_zero.append("0");
            }
            flip = !flip;
        }     
        String start_one = sb_one.toString();
        String start_zero = sb_zero.toString();
        s = s.concat(s);
        int l = 0, r = 0;
        int diff_start_one = 0, diff_start_zero = 0;
        while (r < n) {
            if (start_one.charAt(r) != s.charAt(r)){
                diff_start_one++;
            }
            if (start_zero.charAt(r) != s.charAt(r)){
                diff_start_zero++;
            }
            r++;
        }
        int res = Math.min(diff_start_one, diff_start_zero);
        while (r < 2 * n) {
            // check start one
            if (start_one.charAt(l) != s.charAt(l)) {
                diff_start_one--;
            }
            if (start_one.charAt(r) != s.charAt(r)) {
                diff_start_one++;
            }
            // check start zero
            if (start_zero.charAt(l) != s.charAt(l)) {
                diff_start_zero--;
            }
            if (start_zero.charAt(r) != s.charAt(r)) {
                diff_start_zero++;
            }
            res = Math.min(res, Math.min(diff_start_one, diff_start_zero));
            l++;
            r++;
        }
        return res;
        /**
            111
            000

                0101
            11001100
                1010

            101010101010
            111000111000
            010101010101
                 l----r
            diff = 4            
        */
    }
}