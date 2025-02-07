class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) 
            return s.length();
        
        int result = 0;
        int[] freq = new int[128];
        for(int k=0; k<128; k++){
            freq[k] = -1;
        }
        freq[(int)s.charAt(0)] = 0;
        int i=0, j=1;
        while(j < s.length()){
            int ascii = (int)s.charAt(j);
            if(freq[ascii] > -1 && freq[ascii] >= i){                
                i = freq[ascii] + 1;                
            }
            result = Math.max(result, j - i + 1);
            freq[ascii] = j;
            j++;
        }
        return result;

    }
}