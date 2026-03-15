class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        N = len(people)
        people.sort()
        boats = 0
        l, r = 0, N - 1
        while l <= r:
            if people[r] + people[l] <= limit:
                l += 1
            r -= 1
            boats += 1
        
        return boats 