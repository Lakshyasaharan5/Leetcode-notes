class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, area);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}