class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { 0, heights[0] });
        int area = 0;
        for (int i = 1; i < heights.length; i++) {
            int left = i;
            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] top = stack.pop();
                area = Math.max(area, (i - top[0]) * top[1]);
                left = top[0];
            }
            stack.push(new int[] { left, heights[i] });

        }
        int right = heights.length;
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            area = Math.max(area, (right - top[0]) * top[1]);                
        }
        return area;
    }
}