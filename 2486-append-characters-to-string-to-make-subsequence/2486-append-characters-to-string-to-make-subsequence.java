class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            while (i < s.length() && s.charAt(i) != t.charAt(j)) i++;            
            if (i < s.length()) {
                j++;
            }
            i++;
        }
        return t.length() - j;
    }
}