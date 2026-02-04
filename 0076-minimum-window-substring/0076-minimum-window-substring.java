class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        int min_l = 0, min_r = 0;
        int cnt = t.length();
        int l = 0, r = 0;
        int shortest = Integer.MAX_VALUE;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) - 1);
                if (freq.get(ch) >= 0) cnt--;
            }
            while (cnt == 0) {                
                if (r - l + 1 < shortest) {
                    shortest = r - l + 1;
                    min_l = l;
                    min_r = r;
                }
                if (freq.containsKey(s.charAt(l))) {
                    freq.put(s.charAt(l), freq.get(s.charAt(l)) + 1);
                    if (freq.get(s.charAt(l)) > 0) cnt++;                    
                }
                l++;
            }
            r++;
        }
        
        if (shortest == Integer.MAX_VALUE) return "";
        return s.substring(min_l, min_r + 1);
    }
}