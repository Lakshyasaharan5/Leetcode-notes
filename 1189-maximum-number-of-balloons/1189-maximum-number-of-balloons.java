class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        int[] balloon = new int[26];        
        for (int i = 0; i < "balloon".length(); i++) {
            char curr = "balloon".charAt(i);            
            balloon[curr - 'a']++;
        }
        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);
            if ("balloon".indexOf(curr) != -1)
                freq[curr - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (balloon[i] > 0) {
                res = Math.min(res, freq[i]/balloon[i]);
            }
        }
        return res;
        /**                    
            freq =  [0000000000000]
            balloon = [0000000000000]
            min(freq[i]/match[i])
         */
    }
}