class Solution {
    /**
        s = "ADOBECODEBANC", t = "ABC"
             i
                 j

            freq_s = A:5,B:1,C:1
            freq_t = A:1,B:1,C:1

            expand
            shrink until valid:
                update res
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq_s = new HashMap<>();
        Map<Character, Integer> freq_t = new HashMap<>();

        for (char ch : t.toCharArray()) {
            freq_t.put(ch, freq_t.getOrDefault(ch, 0) + 1);
            freq_s.put(ch, 0);
        }

        int i = 0, j = 0;
        int minWindow = Integer.MAX_VALUE;
        String res = "";
        while (j < s.length()) {
            char curr = s.charAt(j);
            freq_s.put(curr, freq_s.getOrDefault(curr, 0) + 1);
            while (isValid(freq_s, freq_t)) {
                if (j - i + 1 < minWindow) {
                    minWindow = j - i + 1;
                    res = s.substring(i, j + 1);
                }
                freq_s.put(s.charAt(i), freq_s.get(s.charAt(i)) - 1);
                i++;
            }
            j++;
        }
        return res;
    }

    private boolean isValid(Map<Character, Integer> freq_s, Map<Character, Integer> freq_t) {
        for (char key : freq_t.keySet()) {
            if (freq_s.get(key) < freq_t.get(key)) {
                return false;
            }
        }
        return true;
    }
}