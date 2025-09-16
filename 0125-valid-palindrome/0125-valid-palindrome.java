class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r){
            while (l < s.length() && isAlphaNum(s, l)) l++;
            while (r >= 0 && isAlphaNum(s, r)) r--;
            if (l < r){
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    boolean isAlphaNum(String s, int idx){
        char c = s.charAt(idx);
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) 
            return false;
        return true;
    }
}