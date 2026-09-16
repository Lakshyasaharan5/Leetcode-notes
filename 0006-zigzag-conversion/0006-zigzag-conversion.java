class Solution {
    /**
        PAYPALISHIRING 

        P 0 A 0 0 0 0 0
        A P L 0 0 0 0 0
        Y 0 I 0 0 0 0 0

        00 01 02 03 04 05
        10 11 12 13 14 15
        20 21 22 23 24 25

        00 -> 20
        i (0 to Rows)
        i (Rows to 0) j++
                
     */
    public String convert(String s, int numRows) {
        int strLen = s.length();
        char[][] matrix = new char[numRows][strLen];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < strLen; j++) {
                matrix[i][j] = '*';
            }
        }
        int itr = 0;
        int j = 0;
        while (true) {
            int i = 0;
            while (itr < s.length() && i < numRows) {
                matrix[i++][j] = s.charAt(itr++);
            }
            i = numRows - 2;
            j++;
            while (itr < s.length() && i >= 1) {
                matrix[i--][j++] = s.charAt(itr++);                
            }
            if (itr >= s.length()) break;            
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (j = 0; j < strLen; j++) {
                // System.out.print(matrix[i][j] + " ");  
                if (matrix[i][j] != '*')
                    sb.append(matrix[i][j]);              
            }
            // System.out.println();
        }
        return sb.toString();
    }
}