class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int water = 0;
        int leftMax = 0, rightMax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (leftMax > height[l]) {
                    water += leftMax - height[l];
                }
                leftMax = Math.max(leftMax, height[l]);
                l++;
            }else{
                if (rightMax > height[r]){
                    water += rightMax - height[r];
                }
                rightMax = Math.max(rightMax, height[r]);
                r--;
            }
        }
        return water;
    }
}