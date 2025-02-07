class Solution {
    public int characterReplacement(String s, int kk) {
        int n = s.length();
        int[] freq = new int[26];
        int result = Integer.MIN_VALUE;
        boolean dont_freq_j = false;
        int i=0, j=0;
        while(j<n){
            if(!dont_freq_j)
                freq[s.charAt(j) - 'A']++;
            int maxFreq = 0;
            for(int k=0; k<26; k++){
                if(freq[k] > 0){
                    if(freq[k] > maxFreq){
                        maxFreq = freq[k];
                    }
                }
            }
            if(kk >= j-i+1 - maxFreq){
                result = Math.max(result, j-i+1);
                j++;
                dont_freq_j = false;
            }else{
                freq[s.charAt(i) - 'A']--;
                i++;
                dont_freq_j = true;
            }
        }
        return result;
    }
}