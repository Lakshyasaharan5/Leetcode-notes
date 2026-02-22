class Solution {
    public String maximumXor(String s, String t) {
        int ones = 0, zeros = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '1') ones++;
            else zeros++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char bit = s.charAt(i);
            if (bit == '1') {
                if (zeros > 0) {
                    sb.append('1');
                    zeros--;
                } else {
                    sb.append('0');
                    ones--;
                }
            } else {
                if (ones > 0) {
                    sb.append('1');
                    ones--;
                } else {
                    sb.append('0');
                    zeros--;
                }
            }
        }
        return sb.toString();
    }
}