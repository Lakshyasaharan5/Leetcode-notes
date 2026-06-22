class Solution {
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int curr = 0;
        int res = 0;

        for (int j = 0; j < s.length(); j++) {
            if (vowels.indexOf(s.charAt(j)) != -1) {
                curr++;
            }

            if (j >= k && vowels.indexOf(s.charAt(j - k)) != -1) {
                curr--;
            }

            if (j >= k - 1) {
                res = Math.max(res, curr);
            }
        }

        return res;
    }
}