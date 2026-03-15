class Solution:
    def getStrongest(self, arr: List[int], k: int) -> List[int]:
        n = len(arr)
        arr.sort()
        mid = arr[(n - 1) // 2]
        l, r = 0, n - 1
        res = []
        while k > 0:
            if (abs(arr[l] - mid) > abs(arr[r] - mid)):
                res.append(arr[l])
                l += 1
            else:
                res.append(arr[r])
                r -= 1
            k -= 1
        return res
