class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (true) {
            if (l > r) return 0;
            if (l == r) return 1;
            if (s.charAt(l) != s.charAt(r)) return r - l + 1;
            char curr = s.charAt(l);
            while (l < s.length() && s.charAt(l) == curr) l++;
            while (r >= 0 && s.charAt(r) == curr) r--;
        }
        /**
                aaba
                  l
                r
                curr = s[l]
                
                if l > r:
                    return 0
                if l == r:
                    return 1
                if s[l] != s[r]:
                    return r - l + 1
                while l++
                while r--

                curr = b
         */
        
       
    }
}