class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) 
            return false;
        int[] s_ascii = new int[130];
        int[] t_ascii = new int[130];
        for (int i = 0; i < s.length(); i++) {
            if (s_ascii[s.charAt(i)] != t_ascii[t.charAt(i)])
                return false;
            s_ascii[s.charAt(i)] = i+1;
            t_ascii[t.charAt(i)] = i+1;
        }
        return true;
        /**
            s = "abd", 
            t = "cdd"
            
            [1 2 0 2]  abbdd     
            [0 2 1 2]  cddbd
             a b c d
         */
    }
}