class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
                a c s d k f 
                d a r d a d

                i,j
            i+1,j   i,j+1    (i+1,j+1)+1 

                a c b
                a b c

                
                  a c b
                a 0 0 0 0 curr
                b 4 4 4 0 next
                c 2 2 1 0 next
                  4 4 4 4 curr
        
        */
        int m = text1.length(), n = text2.length();
        int[] curr = new int[n + 1];
        int[] next = new int[n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    curr[j] = 1 + next[j + 1]; 
                } else {
                    curr[j] = Math.max(curr[j + 1], next[j]);
                }
            }
            int[] tmp = curr;
            curr = next;
            next = tmp;
        }
        return next[0];
    }
}