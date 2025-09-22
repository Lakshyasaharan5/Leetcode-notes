class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lefts = new int[n];   // store left boundary
        int[] idxs  = new int[n];   // store indices (or heights reference)
        int top = -1, res = 0;

        for (int i = 0; i < n; i++) {
            int left = i;
            while (top >= 0 && heights[idxs[top]] > heights[i]) {
                int idx = idxs[top];
                int start = lefts[top--];
                res = Math.max(res, (i - start) * heights[idx]);
                left = start; // inherit the left boundary
            }
            ++top;
            lefts[top] = left;
            idxs[top]  = i;
        }

        while (top >= 0) {
            int idx = idxs[top];
            int start = lefts[top--];
            res = Math.max(res, (n - start) * heights[idx]);
        }

        return res;
    }
}
