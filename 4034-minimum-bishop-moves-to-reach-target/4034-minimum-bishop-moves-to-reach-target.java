class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        /*
                b  w
                00 01 02 03 04 05 06 07
              w 10 11 12 13 ...
                20 21 22 23
                30 31 32 33 

            00 11 22 ...
            02 04

            r c
            if r == even 
                black -> c even
                white -> c odd
            if r == odd
                black -> c odd
                white -> c even

             black -> ee, oo
             white -> eo, oe

        */
        int sr = source[0] - 1, sc = source[1] - 1;
        int tr = target[0] - 1, tc = target[1] - 1;

        if ((sr % 2 == 0 && sc % 2 == 0) || (sr % 2 != 0 && sc % 2 != 0)) {
            if ((tr % 2 == 0 && tc % 2 == 0) || (tr % 2 != 0 && tc % 2 != 0)) {

            } else {
                return -1;
            }
        }

        if ((sr % 2 != 0 && sc % 2 == 0) || (sr % 2 == 0 && sc % 2 != 0)) {
            if ((tr % 2 != 0 && tc % 2 == 0) || (tr % 2 == 0 && tc % 2 != 0)) {

            } else {
                return -1;
            }
        }

        int curr_r = sr, curr_c = sc;
        while (curr_r >= 0 && curr_c >= 0) {
            if (curr_r == tr && curr_c == tc) {
                return 1;
            }
            curr_r--;
            curr_c--;
        }

        curr_r = sr; curr_c = sc;
        while (curr_r >= 0 && curr_c < 8) {
            if (curr_r == tr && curr_c == tc) {
                return 1;
            }
            curr_r--;
            curr_c++;
        }

        curr_r = sr; curr_c = sc;
        while (curr_r < 8 && curr_c >= 0) {
            if (curr_r == tr && curr_c == tc) {
                return 1;
            }
            curr_r++;
            curr_c--;
        }

        curr_r = sr; curr_c = sc;
        while (curr_r < 8 && curr_c < 8) {
            if (curr_r == tr && curr_c == tc) {
                return 1;
            }
            curr_r++;
            curr_c++;
        }

        return 2;


    }
}