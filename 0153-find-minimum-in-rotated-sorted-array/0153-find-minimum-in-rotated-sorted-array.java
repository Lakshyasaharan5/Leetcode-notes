class Solution {
    public int findMin(int[] nums) {
    //    1 2 3
    //    l m h   -> l<h return m

    //    3 1 2 
    //    l m h   -> h>m h=m

    //    2 3 1
    //    l m h   -> h<m l=m+1

        int l=0, h=nums.length-1;
        while(l<h){
            if(nums[l] < nums[h]) return nums[l];
            
            int m = (l+h)/2; //no need to worry about overflow because range is small

            if(nums[h] > nums[m]) h = m;

            else l = m+1;
        }       
        return nums[h];
    }
}