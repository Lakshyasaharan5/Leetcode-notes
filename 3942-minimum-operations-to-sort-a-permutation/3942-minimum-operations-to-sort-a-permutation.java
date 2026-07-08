class Solution {
    public int minOperations(int[] nums) {
        /**
             
            0 1 2 3 4
            3 4 0 1 2 
             >>>>>
             <<<<<

            2 1 0 4 3 
                <<<
                >>>

            2 1 0 4 3
            3 4 0 1 2 rev
            2*left

            [2,0,1,3]

            find 0
            check by going right (then just left)
            check by going left (then rev and then left)

            0 1 2 3 4
            2 1 0 4 3
                ^

            0 1 2 3 4
            3 4 0 1 2
            1 2 3 4 0
                    ^
            

            if (sorted (maybe rotated))
                return left (pos of 0)
            reverse it
            if (sorted rev (maybe rotated))
                return left (pos of 0)
            return -1
         */
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        if (checkSorted(nums)) {
            int zero = findZero(nums);
            res = Math.min(res, Math.min(zero, n - zero + 2));
        }
        reverse(nums);
        if (checkSorted(nums)) {
            int zero = findZero(nums);
            res = Math.min(res, 1 + Math.min(zero, n - zero));
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;

    }

    private void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }        
    }

    private int findZero(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0)
                return i;
        return -1;
    }

    private boolean checkSorted(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[(i + 1) % arr.length]) k++;
            if (k > 1) return false;
        }
        return true; 
    }
}