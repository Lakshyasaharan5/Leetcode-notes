class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            first[idx] = Math.min(first[idx], i);
            last[idx] = i;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == Integer.MAX_VALUE) continue;
            int firstIndex = first[i], lastIndex = last[i];
            if (lastIndex - firstIndex < 2) continue;
            int unique = 0;
            boolean[] seen = new boolean[26];
            for (int j = firstIndex + 1; j < lastIndex; j++) {
                int idx = s.charAt(j) - 'a';
                if (!seen[idx]) {
                    seen[idx] = true;
                    unique++;
                } 
            }
            result += unique;
        }
        return result;
    }
}