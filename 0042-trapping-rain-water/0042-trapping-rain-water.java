class Solution {
    public int trap(int[] height) {
        int result = 0;
        int startIndex = 0;        

        //we want monotonic decreasing stack so skip to the point where height start to decline
        while(startIndex < height.length - 1 && height[startIndex] <= height[startIndex + 1] ){
            startIndex++;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(startIndex);
        
        for(int i = startIndex + 1; i < height.length; i++){
            //in case of duplicate just pop when they come like if we have 1 1 1 then each 1 will remove the previous 1 from stack
            if(height[i] < height[stack.peek()]){
                stack.push(i);
            }else{
                int hinderanceBetween = height[stack.peek()];
                while(!stack.empty() && height[stack.peek()] <= height[i]){
                    int top = stack.pop();
                    result += (i - top - 1) * (Math.min(height[i], height[top]) - hinderanceBetween);
                    hinderanceBetween = Math.max(height[top], hinderanceBetween);
                }
                if(!stack.empty()){
                    result += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - hinderanceBetween);
                }
                stack.push(i);
            }
        }

        return result;
    }
}