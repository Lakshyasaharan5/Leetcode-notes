class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lmax = l, rmax = r;
        int water = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                l++;
                if (height[l] > height[lmax]) {
                    lmax = l;
                } else {
                    water += height[lmax] - height[l];
                }
            } else {
                r--;
                if (height[r] > height[rmax]) {
                    rmax = r;
                } else {
                    water += height[rmax] - height[r];
                }
            }
        }
        return water;

        //               3
        //       2 # # # 3 2 # 2
        // _,1,#,2,1,#,1,3,2,1,2,1
        //               L           
        //             R
        //               Lmax                  
        //                     Rmax

        //    water += R-L+1 (1 + 1 + 2 + 1 + 1)
        
    }
}