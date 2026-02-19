class Solution {
    HashMap<Integer, String> symbols;
    HashMap<Integer, String> four_nine;
    public String intToRoman(int num) {
        symbols = new HashMap<>();
        symbols.put(1, "I");        
        symbols.put(5, "V");
        symbols.put(10, "X");
        symbols.put(50, "L");
        symbols.put(100, "C");
        symbols.put(500, "D");
        symbols.put(1000, "M");
        four_nine = new HashMap<>();
        four_nine.put(4, "IV");
        four_nine.put(9, "IX");
        four_nine.put(40, "XL");
        four_nine.put(90, "XC");
        four_nine.put(400, "CD");
        four_nine.put(900, "CM");
        Stack<String> st = new Stack<>();
        int tens = 1;
        int temp = num;
        while (temp > 0) {
            int curr = ((num % (tens * 10)) / tens) * tens;

            if (four_nine.containsKey(curr)) {
                st.push(four_nine.get(curr));
            } else {
                st.push(getRoman(curr, new StringBuilder()));
            }

            tens *= 10;
            temp /= 10;
        }
        StringBuilder roman = new StringBuilder();
        while (!st.isEmpty()) {
            roman.append(st.pop());
        }
        return roman.toString();
    }

    private String getRoman(int n, StringBuilder sb) {
        if (n == 0) return sb.toString();
        int[] numerals = {1, 5, 10, 50, 100, 500, 1000};
        int i = numerals.length - 1;
        while (i >= 0 && numerals[i] > n) i--;
        sb.append(symbols.get(numerals[i]));        
        return getRoman(n - numerals[i], sb);
    } 
}