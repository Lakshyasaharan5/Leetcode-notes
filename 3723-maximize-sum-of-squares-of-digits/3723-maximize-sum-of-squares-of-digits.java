class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder res = new StringBuilder();
        while(num-- > 0) {
            for(int i = 9; i > 0; i--) {
                if(sum >= i) {
                    sum -= i;
                    res.append("" + i);
                    break;
                }
            }
            if(sum == 0) break;
        }
        if(sum > 0) return "";        
        return res.toString() + (num > 0 ? "0".repeat(num) : "");        
    }
}