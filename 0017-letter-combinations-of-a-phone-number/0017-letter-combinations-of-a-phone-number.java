class Solution {
    /**
        2 : abc
        3 : def
        4 : ghi

        a       b c
      d  e   f
    g h i

        for (letter in map[digits[i]]):
            list.add(letter)
            dfs(i+1)
            list.remove()


        23
        ad, ae af, bd be bf...
     */
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> telepad = new HashMap<>();
        telepad.put(2, "abc");
        telepad.put(3, "def");
        telepad.put(4, "ghi");
        telepad.put(5, "jkl");
        telepad.put(6, "mno");
        telepad.put(7, "pqrs");
        telepad.put(8, "tuv");
        telepad.put(9, "wxyz");
        List<String> res = new ArrayList<>();
        dfs(telepad, digits, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(Map<Integer, String> telepad, String digits, int i, StringBuilder curr, List<String> res) {
        if (i == digits.length()) {
            res.add(new String(curr.toString()));
            return;
        }
        int currDigit = Integer.parseInt(digits.charAt(i) + "");
        for (char ch : telepad.get(currDigit).toCharArray()) {
            curr.append(ch);
            dfs(telepad, digits, i + 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}