class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i=0; i<s.length(); i++){
            int even = expand(s, i, i+1);
            int odd = expand(s, i, i);
            res += even + odd;
        }

        return res;
    }

    int expand(String s, int l, int r){
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }
}