class Solution {
    public void moveZeroes(int[] nums) {
        // 1, 3, 12, 0, 0
        //           nz
        //           z
        int n = nums.length;
        int z = 0, nz = 0; //z: zero, nz: non zero
        while (z < n && nz < n) {
            while (z < n && nums[z] != 0) z++;
            nz = z;
            while (nz < n && nums[nz] == 0) nz++;
            if (z < n && nz < n) {
                int t = nums[z];
                nums[z] = nums[nz];
                nums[nz] = t;
            }
        }
    }
}