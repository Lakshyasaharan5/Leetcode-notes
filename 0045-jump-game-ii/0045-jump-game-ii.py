class Solution:
    def jump(self, nums: List[int]) -> int:
        """
        0 1 2 3 4
        1,2,3
            ^
            curr_end = 3            
            max_reach = 3  
            
        jumps = 1
        """
        if len(nums) == 1:
            return 0
        curr_end = nums[0]
        max_reach = nums[0]
        jumps = 1
        for i in range(len(nums) - 1):
            if i + nums[i] > max_reach:
                max_reach = i + nums[i]
            if i == curr_end:
                curr_end = max_reach
                jumps += 1

        return jumps


        
        