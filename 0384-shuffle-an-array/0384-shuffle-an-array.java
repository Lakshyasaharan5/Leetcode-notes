class Solution {
    /**
    
        [1 2 3] original

        [1 5 3 4 2] 
                 i
     */
    int[] original;
    Random random;
    int size;
    public Solution(int[] nums) {
        original = nums;
        size = nums.length;
        random = new Random();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        int[] shuffled = new int[size];
        for (int i = 0; i < size; i++) {
            shuffled[i] = original[i];
        }
        for (int i = size - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            int t = shuffled[randomIndex];
            shuffled[randomIndex] = shuffled[i];
            shuffled[i] = t;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */