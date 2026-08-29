class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        /**
        
            00 01 02 ... 07
            10 k* 12
            20 21 22
            ...
            70            77

            from king -> up, down, left, right, all 4 diag sides and see 
            if there is any attacking queen++
            O(64)
        
         */
        // mark queen positions in boolean array
        boolean[][] queenPositions = new boolean[8][8];
        for (int[] q : queens) {
            queenPositions[q[0]][q[1]] = true;
        }
        List<List<Integer>> res = new ArrayList<>();

        // up -> [r--][c]
        int r = king[0] - 1, c = king[1];
        while (r >= 0) {
            if (queenPositions[r][c]) {
                res.add(Arrays.asList(r,c));
                break;
            }
            r--;
        }

        // down -> [r++][c]
        r = king[0] + 1; 
        c = king[1];
        while (r < 8) {
            if (queenPositions[r][c]) {
                res.add(Arrays.asList(r,c));
                break;
            }
            r++;
        }

        // left -> [r][c--]
        r = king[0]; 
        c = king[1] - 1;
        while (c >= 0) {
            if (queenPositions[r][c]) {
                res.add(Arrays.asList(r,c));
                break;
            }
            c--;
        }

        // right -> [r][c++]
        r = king[0]; 
        c = king[1] + 1;
        while (c < 8) {
            if (queenPositions[r][c]) {
                res.add(Arrays.asList(r,c));
                break;
            }
            c++;
        }

        // diagonal upper left -> [r--][c--]
        r = king[0] - 1; 
        c = king[1] - 1;
        while (r >= 0 && c >= 0) {
            if (queenPositions[r][c]) {
                res.add(Arrays.asList(r,c));
                break;
            }
            r--;
            c--;
        }

        // diagonal upper right -> [r--][c++]
        r = king[0] - 1; 
        c = king[1] + 1;
        while (r >= 0 && c < 8) {
            if (queenPositions[r][c]) {
                res.add(Arrays.asList(r,c));
                break;
            }
            r--;
            c++;
        }

        // diagonal lower left -> [r++][c--]
        r = king[0] + 1; 
        c = king[1] - 1;
        while (r < 8 && c >= 0) {
            if (queenPositions[r][c]) {
                res.add(Arrays.asList(r,c));
                break;
            }
            r++;
            c--;
        }

        // diagonal lower right -> [r++][c++]
        r = king[0] + 1; 
        c = king[1] + 1;
        while (r < 8 && c < 8) {
            if (queenPositions[r][c]) {
                res.add(Arrays.asList(r,c));
                break;
            }
            r++;
            c++;
        }

        return res;
    }
}