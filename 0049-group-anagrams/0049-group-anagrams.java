class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> sortedWordMap = new HashMap<>();
        for (String s : strs) {
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) freq [ch - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int f : freq) sb.append(f).append('#');
            String sorted = sb.toString();
            sortedWordMap.putIfAbsent(sorted, new ArrayList<String>());
            sortedWordMap.get(sorted).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (ArrayList<String> group : sortedWordMap.values()) {
            res.add(group);
        }
        return res;
    }
}