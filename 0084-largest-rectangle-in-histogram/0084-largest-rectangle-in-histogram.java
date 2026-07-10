class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{0, 0});
        int maxArea = Integer.MIN_VALUE;
        for (int i = 1; i < heights.length; i++) {
            int left = i;
            while (!st.isEmpty() && heights[st.peek()[0]] >= heights[i]) {
                int[] top = st.pop();  // (curr index, how far left)
                int currIndex = top[0];
                left = top[1];         
                maxArea = Math.max(maxArea, (i - left) * heights[currIndex]);       
            }
            st.push(new int[]{i, left});
        }
        int right = heights.length;
        while (!st.isEmpty()) {
            int[] top = st.pop();
            maxArea = Math.max(maxArea, (right - top[1]) * heights[top[0]]);
        }
        return maxArea;
        
        /**
            1 1 1 1 1
                i
            st = []
             0 1 2 3 4 5
            [2,1,5,6,2,3]
                       i
                     left = 
            st = [(1,0)(4,2)(5,5)]
            (curr index, how far left)
            while pop()
                max area = (i - left) * h[curr]
         */
    }
}