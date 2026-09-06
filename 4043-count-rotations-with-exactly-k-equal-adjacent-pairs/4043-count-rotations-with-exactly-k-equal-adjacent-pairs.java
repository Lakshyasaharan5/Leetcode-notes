class Solution {
    /*
        abcaabca
        i
            j
        score=1

        s = s + s (all rotations)
        create window of len
        slide and maintain score
        if score==k:
            res++;
                   
    */
    public int countRotations(String s, int k) {
        String expanded = s + s;
        int i = 0, j = 1;
        int score = 0;
        int res = 0;
        /*
        abcaabca
        i
            j
        */
        while (j < s.length()) {
            if (expanded.charAt(j) == expanded.charAt(j - 1)) {
                score++;
            }  
            j++;                    
        }
        if (score == k) res++;
        
        while (j < expanded.length() - 1) {            
            i++;
            if (expanded.charAt(i) == expanded.charAt(i - 1)) {
                score--;
            }
            if (expanded.charAt(j) == expanded.charAt(j - 1)) {
                score++;
            }
        
            if (score == k) {
                res++;
            }
            j++;
        }
        return res;
    }
}