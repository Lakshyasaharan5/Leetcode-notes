class Solution {
    public int largestRectangleArea(int[] heights) {
        int[][] stack = new int[heights.length][2];
        int top = -1, res = 0;
        for (int i = 0; i < heights.length; i++) {
            int[] curr = new int[] { i, i };
            while (top >= 0 && heights[stack[top][1]] > heights[i]) {
                int[] popped = stack[top--];
                res = Math.max(res, (i - popped[0]) * heights[popped[1]]);
                curr[0] = popped[0];
            }
            stack[++top] = curr;
        }
        while (top >= 0) {
            int[] popped = stack[top--];
            res = Math.max(res, (heights.length - popped[0]) * heights[popped[1]]);
        }
        return res;
    }
}