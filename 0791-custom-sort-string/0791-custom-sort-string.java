class Solution {
    public String customSortString(String order, String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            int curr = ch - 'a';
            while (freq[curr]-- > 0) {
                sb.append(ch);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}