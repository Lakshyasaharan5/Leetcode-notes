class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        queue = deque([start])
        while queue:
            node = queue.popleft()
            if arr[node] == 0: return True
            left = node - arr[node]
            right = node + arr[node]
            if left >= 0 and left < len(arr) and arr[left] >= 0:
                arr[left] = -arr[left]
                queue.append(left)
            if right >= 0 and right < len(arr) and arr[right] >= 0:
                arr[right] = -arr[right]
                queue.append(right)

        return False