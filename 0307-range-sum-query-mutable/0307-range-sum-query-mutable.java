class NumArray {

    /**
          [0 1 2 3]
    
            [03]
        [01]    [23]
      [0] [1]  [2] [3]  

    
      03, 01, 23, 0, 1, 2, 3
       0  1    2  3  4  5  6
    
       left = dfs(l, m, 2i+1)
       right = dfs(m+1, r, 2i+2) 
       arr[currIndex] = left + right     
           
        3 4

        
     */
    int[] tree;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[4 * n];
        build(0, n - 1, 0);        
    }

    private int build(int l, int r, int i) {
        if (l == r) {
            tree[i] = nums[l];
            return tree[i];
        }

        int m = (r - l) / 2 + l;

        int left = build(l, m, 2 * i + 1);
        int right = build(m + 1, r, 2 * i + 2);

        tree[i] = left + right;
        return tree[i];
    }

    public void update(int index, int val) {
        this.nums[index] = val;
        update(0, n - 1, 0, index);
    }

    private int update(int l, int r, int treeIndex, int numsIndex) {
        if (l > numsIndex || numsIndex > r) {
            return tree[treeIndex];
        }
        if (l == r) {
            return tree[treeIndex] = nums[numsIndex];
        }        
        int m = (r - l) / 2 + l;
        int left = update(l, m, 2 * treeIndex + 1, numsIndex);
        int right = update(m + 1, r, 2 * treeIndex + 2, numsIndex);

        tree[treeIndex] = left + right;
        return tree[treeIndex];
    }

    public int sumRange(int left, int right) {        
        return sumRange(0, n - 1, 0, left, right);
    }

    private int sumRange(int l, int r, int index, int ql, int qr) {
        // outside range
        if (qr < l || ql > r) { 
            return 0;
        }

        // complete overlap
        if (ql <= l && r <= qr) { 
            return tree[index];
        }        

        // partial overlap
        int m = (r - l) / 2 + l;
        int left = sumRange(l, m, 2 * index + 1, ql, qr);
        int right = sumRange(m + 1, r, 2 * index + 2, ql, qr);

        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */