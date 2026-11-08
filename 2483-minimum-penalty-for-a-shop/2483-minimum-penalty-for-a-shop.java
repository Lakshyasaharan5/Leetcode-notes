class Solution {
    /**
            1 2
        0 1 2 3
        Y Y N Y
        3 2 1 1
        0 0 1 1
        
        xxxxxx c xxxxxxx
        sum N     sum Y
              
     */
    public int bestClosingTime(String customers) {
        int len = customers.length();
        int[] prefixN = new int[len];
        prefixN[0] = (customers.charAt(0) == 'N' ? 1 : 0);
        for (int i = 1; i < len; i++) {
            prefixN[i] = prefixN[i - 1] + (customers.charAt(i) == 'N' ? 1 : 0);
        }
        int earliest = len;
        int minPenalty = prefixN[len - 1];
        int postY = 0;
        for (int i = len - 1; i >= 0; i--) {
            postY += (customers.charAt(i) == 'Y' ? 1 : 0);
            int currPenalty = postY + (i > 0 ? prefixN[i - 1] : 0);
            if (currPenalty <= minPenalty) {
                earliest = i;
                minPenalty = currPenalty;
            }
        }
        return earliest;
    }
}