class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int i = 0, j = 0;
        int curr = 0, res = 0;
        while (j < s.length()) {
            if (j - i + 1 <= k) {
                if (vowels.contains(s.charAt(j))) {
                    curr++;
                }
                j++;
            } else {
                if (vowels.contains(s.charAt(j)))
                    curr++;
                if (vowels.contains(s.charAt(i)))
                    curr--;
                i++;
                j++;
            }
            res = Math.max(res, curr);
        }

        return res;
    }
}