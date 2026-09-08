class Solution {
    /**
        position[] -> sorted (strictly increasing)
        pos[i] -> position of robot at t = 0

        speed[i] -> speed of robot i
        distance

        [r]/[rrrrr] -> d = v*t

        [r1] ---- d ---- [r2,r3] ---- d ----- [r4]
                                         merge [r1,r2,r3,r4]


        
        position = [1,5,6,20], 
           speed = [4,3,2,3],       distance = 1

        1---5 6-------------20
        4   2 2             3

        
        initial distance merges
                
        process resulting groups left → right
                
        stack representing surviving groups

        1---5 6-------------20
        4   2 2             3
            i
        st = [4]
        distance = 10

        loop:
            merge towards the right
            monotonic stack
     */
    public int countGroups(int[] position, int[] speed, int distance) {
        Stack<Integer> st = new Stack<>();
        /**
                1---5 6-------------20
                4   3 2             3
                                    i
                st = [2]
                currSpeed = 2
                distance = 1
         */
        for (int i = 0; i < position.length; i++) {
            int currSpeed = speed[i];
            while (i < position.length - 1 && position[i + 1] - position[i] <= distance) {
                i++;
                currSpeed = speed[i];
            }
            while (!st.isEmpty() && st.peek() > currSpeed) {
                st.pop();
            }
            st.push(currSpeed);
        }
        return st.size();
    }
}