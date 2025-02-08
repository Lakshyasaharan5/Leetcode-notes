class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] freq1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        int[] freq2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
        }
        int l = 0, r = s1.length() - 1;
        while (r < s2.length()) {
            if(checkPermutation(freq1, freq2)){
                return true;
            }
            freq2[s2.charAt(l) - 'a']--;
            l++;
            r++;
            if(r < s2.length())
                freq2[s2.charAt(r) - 'a']++;
        }        
        return false;
    }
    boolean checkPermutation(int[] freq1, int[] freq2){
        for(int i=0; i<26; i++){
            if(freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
}