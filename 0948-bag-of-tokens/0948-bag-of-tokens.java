class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        int score = 0, maxScore = 0;
        while (l <= r) {
            if (power >= tokens[l]) {
                score++;
                maxScore = Math.max(maxScore, score);
                power -= tokens[l];
                l++;
            } else if (score > 0) {
                score--;
                power += tokens[r];
                r--;
            } else {
                break;
            }
        }
        return maxScore;
        /**
                [100,200,300,400], 
                  l
                              r
                 score = 0
                 power = 1000
                
         */
        
    }
}