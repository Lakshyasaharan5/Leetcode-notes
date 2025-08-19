class NumArray:

    def __init__(self, nums: List[int]):
        self.n = len(nums)
        self.nums = nums
        self.Tree = [0] * (4 * self.n)
        self.build_tree(nums, 1, 0, self.n - 1)

    def build_tree(self, nums, idx, l, r):
        if l == r:
            self.Tree[idx] = nums[l]
            return nums[l]
        m = (l + r)//2
        left = self.build_tree(nums, 2*idx, l, m)
        right = self.build_tree(nums, 2*idx + 1, m + 1, r)
        self.Tree[idx] = left + right
        return self.Tree[idx]

    def update(self, index: int, val: int) -> None:
        self.updateHelper(1, 0, self.n - 1, index, val)
        self.nums[index] = val

    def updateHelper(self, treeIdx, nodeL, nodeR, index, val):     
        if nodeL == nodeR:
            if nodeL <= index and index <= nodeR:
                self.Tree[treeIdx] = self.Tree[treeIdx] - self.nums[index] + val
            return               
        mid = (nodeL + nodeR)//2
        if index <= mid:
            self.updateHelper(2*treeIdx, nodeL, mid, index, val)
        else:
            self.updateHelper(2*treeIdx+1, mid+1, nodeR, index, val)
        if nodeL <= index and index <= nodeR:
            self.Tree[treeIdx] = self.Tree[treeIdx] - self.nums[index] + val

    def sumRange(self, left: int, right: int) -> int:
        return self.sumRangeHelper(1, 0, self.n - 1, left, right)
    
    def sumRangeHelper(self, idx, nodeL, nodeR, qL, qR):
        if qL <= nodeL and nodeR <= qR:
            return self.Tree[idx]
        if nodeR < qL or nodeL > qR:
            return 0
        mid = (nodeL + nodeR)//2
        left = self.sumRangeHelper(2*idx, nodeL, mid, qL, qR)
        right = self.sumRangeHelper(2*idx + 1, mid + 1, nodeR, qL, qR)
        return left + right


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)

        #     01234
        #    012    34
        #    0 12   3 4
        #      1 2