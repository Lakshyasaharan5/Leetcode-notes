/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        /*
            1 2 3 4 5 6 7 8 9 10
            l
            m
              r
        */
        int l = 1, r = n;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (guess(m) == -1) {
                r = m - 1;
            } else if (guess(m) == 1) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
}