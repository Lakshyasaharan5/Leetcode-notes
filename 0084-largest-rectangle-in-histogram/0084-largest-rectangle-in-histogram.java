class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();                
        
        // monotonic increase stack by going left to right
        int[] next_smaller_right = new int[n]; 
        for(int i=0; i<n; i++){
            while(!st.empty() && height[st.peek()] > height[i]){
                next_smaller_right[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.empty()){
            next_smaller_right[st.pop()] = n;
        }

        // monotonic increase stack by going right to left
        int[] next_smaller_left = new int[n]; 
        for(int i=n-1; i>=0; i--){
            while(!st.empty() && height[st.peek()] > height[i]){
                next_smaller_left[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.empty()){
            next_smaller_left[st.pop()] = -1;
        }

        int result = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int area = (next_smaller_right[i] - next_smaller_left[i] - 1) * height[i];
            result = Math.max(result, area);
        }

        return result;
    }
}