class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;        
        int[] prefix = new int[n];
        prefix[0] = (isVowel(words[0].charAt(0)) && isVowel(words[0].charAt(words[0].length() - 1)) ? 1 : 0);
        for (int i = 1; i < n; i++) {
            String w = words[i];
            int currVowel = isVowel(w.charAt(0)) && isVowel(w.charAt(w.length() - 1)) ? 1 : 0;
            prefix[i] = currVowel + prefix[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            res[i] = prefix[q[1]] - (q[0] > 0 ? prefix[q[0] - 1] : 0);
        }
        return res;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}