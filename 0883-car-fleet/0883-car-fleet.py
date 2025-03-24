class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        """
        0 1 2 3 4 5 6 7 8 9 10 11 12
                             2       
                        4
                  1
              3        
        1         
        11 3 7 1 1

        0  3  5  8  10
        1  3  1  4   2
        11 3  7  1   1

        0   2   4
        4   2   1
        25  49  96
        """
        time = [-1] * target
        n = len(position)
        for i in range(n):
            time[position[i]] = (target - position[i])/speed[i]

        mono = []
        for i in range(target):
            if time[i] < 0: continue
            while mono and mono[-1] <= time[i]:
                mono.pop()
            mono.append(time[i])

        return len(mono)
            


