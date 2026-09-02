class Solution {
    /**
        nums[i] = x

        aaaaa... x times

        Choose two adjacent equal letters and replace them with the next letter in the alphabet.

        aa -> b or bb -> c
        zz -> nope

        *********************************************************
        Example 1:
        Input: nums = [2,5,7]

        Output: ["b","ca","cba"]

        Explanation:

        nums[0] = 2: "aa" → "b".
        nums[1] = 5: "aaaaa" → "baaa" → "bba" → "ca".
        nums[2] = 7: "aaaaaaa" → "baaaaa" → "bbaaa" → "bbba" → "cba".
        Therefore, ans = ["b", "ca", "cba"].
        *********************************************************
        Example 2:
        Input: nums = [3,9,1]

        Output: ["ba","da","a"]

        Explanation:

        nums[0] = 3: "aaa" → "ba".
        nums[1] = 9: "aaaaaaaaa" → "baaaaaaa" → "bbaaaaa" → "bbbaaa" → "bbbba" → "cbba" → "cca" → "da".
        nums[2] = 1: No transformation can be applied, so the result is "a".
        Therefore, ans = ["ba", "da", "a"].
        *********************************************************

        aaaaaa..... x times
        start from first
            convert the adjacent chars to next alphabet
        repeat

        min heap = d
        first = a, peek second = b
        res = res + "da"

        Time: O(xlogx * n)
        Space: O(n + len(res))

        1 -> a
        2 -> b
        3 -> ba
        4 -> c
        5 -> ca
        6 -> cb
        7 -> cba
        8 -> d
        9 -> da
       10 -> db
       11 -> dba

       a,  
       b, ba, 
       c, ca, cb, cba
       d, da, db, dba, dc, dca, dcb, dcba
       e...
       ...
       zzzzzzzzzzzzzzzz.....

       1 a   
       2 b
       3 ba
       4 c
       5 ca
       6 cb
       7 cba
       8 d
       ..
       16 e

       2^k = start kth + 1 char from alphabet

       9  -> 8 + 1
       10 -> 8 + 2
       11 -> 8 + 2 + 1
       12 -> 8 + 4
       13 -> 8 + 4 + 1
       14 -> 8 + 4 + 2
       15 -> 8 + 4 + 2 + 1
       16 -> 16
       17 -> 16 + 1

       1, 2, 4, 8, 16, 32.....

       0001 a
       0010 b
       0011 ba
       0100 c
       0101 ca
       0110 cb
       0111 cba
       1000 d
       
       convert to binary
       shift right and see if bit is 1

       7
       if ((7 >> 0) & 1):
            res = (char)('a' + 0) + res

        if ((7 >> 1) & 1):
            res = (char)('a' + 1) + res


        try clamp at 2^1
        1 - a
        2 - b
        3 - ba
        4 - 4 (2 + 2)
        5 - 4(2 + 2) + 1 
        9 - 8(4(2+2) + 4(2+2)) + 1 = 2 2 2 2 1
        11 - 2 2 2 2 2 1        

        3/2 = 1
        3%2 = 1
        ba

     */
    public String[] largestString(int[] nums) {
        String[] output = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {  
            int num = nums[i];  
            String appendZ = "";                    
            if (num > (1 << 25)) {
                int concatTimes = num/(1 << 25);
                while (concatTimes-- > 0) {
                    appendZ += "z";
                }
                num %= 1 << 25;
            }
            String res = "";
            for (int shift = 0; shift < 26; shift++) {
                if (((num >> shift) & 1) == 1) {
                    res = (char)(shift + 'a') + res;
                }
            }
            output[i] = appendZ + res;
        }

        return output;
    }
}