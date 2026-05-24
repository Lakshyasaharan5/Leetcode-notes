class Solution {
    public int searchInsert(int[] arr, int target) {
    //     0 1 2 3 4
    //    [1,3].   target=2. ans=1
    //     l r
    //     m
    //       lr   
    //     
    //
    //
    //
            // if(arr.length==1){
            //     return target<=arr[0] ? 0 : 1;
            // }
            int l=0, r=arr.length-1;
            while(l<r){
                int m = (r-l)/2 + l;
                if(arr[m]==target) return m;

                if(arr[m]<target){
                    l=m+1;
                }else{
                    r=m;
                }             
            }

            if(arr[l]<target) return l+1;

            return l;
         
    }
}