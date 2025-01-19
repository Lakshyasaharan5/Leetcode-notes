class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        int result = 1;
        Set<Integer> helper = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        
        for(int n : nums){
            helper.add(n);
        }

        int lcount = 0, rcount = 0;
        for(int n : nums){
            if(seen.contains(n)) continue;
            seen.add(n);
            // check left
            int l = n-1;
            while(true){                
                if(!helper.contains(l)) 
                    break;
                lcount++;
                seen.add(l);
                l--;
            }
            
            // check right
            int r = n+1;
            while(true){                
                if(!helper.contains(r)) 
                    break;
                rcount++;
                seen.add(r);
                r++;
            }

            //update our result count
            result = Math.max(result, (lcount + rcount + 1));
            lcount = 0;
            rcount = 0;
        }

        return result;
    }
}