class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int a = s.charAt(n - 1) == '0' ? 0 : 1;
        int b = 1;
        for (int i = n - 2; i >=0; i--) {
            int c = 0;
            int one = Integer.parseInt(s.charAt(i) + "");
            int two = Integer.parseInt(s.charAt(i) + "" + s.charAt(i + 1));
            if (one == 0) {
                c = 0;
            } else {
                c = a;
                if (two <= 26) {
                    c += b;
                }
            }
            b = a;
            a = c;
        } 
        return a;
     }
}