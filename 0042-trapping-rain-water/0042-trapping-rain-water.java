class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int lmax = height[0], rmax = height[r];
        int water = 0;
        while (l < r) {            
            if (height[l] < height[r]) {
                lmax = Math.max(lmax, height[l]);
                water += lmax - height[l];
                l++;
            } else {
                rmax = Math.max(rmax, height[r]);
                water += rmax - height[r];
                r--;
            }
        }
        return water;
        /**
                             r
         l
        [1,1,0,2,1,0,1,3,2,1,2,1]
                       m     
                         m
           water = 6
           1 # 2 1 # 1 3 2 1 2 1
               2 # # # 3 2 # 2
                       3 
            
            $          
            $   $  $     
            $...$..$...$....
            l
                       r   
        */
    }
}