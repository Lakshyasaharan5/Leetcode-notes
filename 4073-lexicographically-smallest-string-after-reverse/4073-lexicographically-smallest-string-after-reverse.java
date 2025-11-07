class Solution {
    public String lexSmallest(String s) {
        if (s.length() == 1) return s;                
        char smallChar = s.charAt(0);
        int index = 0;
        String leftSmallest = new StringBuilder(s).toString();
        for(int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (i < s.length() - 1 && curr == s.charAt(i+1)) continue; // skip duplicates
            if (curr < smallChar) {
                smallChar = curr;
                index = i;
            } else if (curr == smallChar) {
                leftSmallest = check(s, i, leftSmallest);
            }
        }
        leftSmallest = check(s, index, leftSmallest);

        char bigChar = s.charAt(s.length() - 1);
        index = s.length() - 1;
        String rightSmallest = new StringBuilder(s).toString();
        for(int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);
            if (i > 0 && curr == s.charAt(i-1)) continue; // skip duplicates
            if (curr > bigChar) {                
                index = i;
            } else if (curr == bigChar) {
                rightSmallest = checkRight(s, i, rightSmallest);
            }
        }
        rightSmallest = checkRight(s, index, rightSmallest);
        // z c b a z a a b
        //               ^
        return leftSmallest.compareTo(rightSmallest) < 0 ? leftSmallest : rightSmallest;
    }

    private String check(String s, int n, String smallest) {
        String reversed = null;
        if (n == s.length() - 1)
            reversed = new StringBuilder(s).reverse().toString();
        else
            reversed = new StringBuilder(s.substring(0,n+1)).reverse().toString() + s.substring(n+1); 
        if (reversed.compareTo(smallest) < 0) {
            return new StringBuilder(reversed).toString();
        }
        return smallest;
    }

    private String checkRight(String s, int n, String smallest) {
        String reversed = null;
        if (n == s.length() - 1)
            reversed = new StringBuilder(s).reverse().toString();
        else
            reversed = s.substring(0,n) + new StringBuilder(s.substring(n)).reverse().toString(); 
        if (reversed.compareTo(smallest) < 0) {
            return new StringBuilder(reversed).toString();
        }
        return smallest;
    }
}