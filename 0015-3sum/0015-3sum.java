class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int n: nums)
            System.out.print(n +" ");
        int k=0, i=0, j=0;
        // -4 -1 -1 0 1 2
        //          k  
        //            i-j    
        while(k<nums.length-2){            
            int target = -1*nums[k];
            i=k+1;
            j=nums.length-1;
            while(i<j){
                int twoSum = nums[i] + nums[j];
                if(twoSum == target){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[k]);
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    result.add(curr);
                    i++;
                    while(i<nums.length && i<j && nums[i]==nums[i-1])
                        i++;
                    j--;
                    while(j>0 && j>i && nums[j]==nums[j+1])
                        j--;
                }else if(twoSum > target){
                    j--;                    
                }else{
                    i++;
                }
            }
            k++;
            while(k<nums.length-2 && nums[k]==nums[k-1])
                k++;
        }
        return result;
    }
}