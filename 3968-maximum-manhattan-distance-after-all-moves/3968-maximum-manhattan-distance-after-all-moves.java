class Solution {
    public int maxDistance(String moves) {
        int x = 0, y = 0;
        int empty = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == '_') {
                empty++;
            } else if (ch == 'R') {
                x++;
            } else if (ch == 'L') {
                x--;
            } else if (ch == 'U') {
                y++;
            } else if (ch == 'D') {
                y--;
            }
        }
        if (x < 0) x *= -1;
        if (y < 0) y *= -1;
        return x + y + empty;
        /**
                
                L_D_
                L
                D
                --

                U_R
                U
                R
                _
                
                U_R_D_L

                UD
                RL
                ---

                0 0 0 0 0 0 0 0 0 0 0
                0 0 U R R R 0 0 0 0 0
                0 0 * 0 0 D 0 0 0 0 0
                0 0 0 0 L D 0 0 0 0 0
                0 0 0 0 0 0 0 0 0 0 0
                
        
         */
    }
}