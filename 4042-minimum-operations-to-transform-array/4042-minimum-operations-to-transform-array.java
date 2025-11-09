class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        // [2,8]   [1,7,3]
        // 1---------2
        // distance = 1
        long operations = 0, distance = 100002;
        int villian = nums2[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            operations += Math.abs(nums1[i] - nums2[i]);
            int left = Math.min(nums1[i], nums2[i]);
            int right = Math.max(nums1[i], nums2[i]);
            if(left <= villian && villian <= right) {
                distance = 0;
            } else if(villian < left) {
                distance = Math.min(distance, Math.abs(villian - left));
            } else {
                distance = Math.min(distance, Math.abs(villian - right));
            }
        }
        return operations + 1 + distance;

    }
}