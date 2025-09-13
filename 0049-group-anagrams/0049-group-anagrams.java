class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // iterate over strs
        // for each string will encode into 26 char hash
        // put that into hashmap
        // iterate over hashmap to create final result
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String hash = encode(s);
            if (!map.containsKey(hash)){
                map.put(hash, new LinkedList<String>());
            }            
            map.get(hash).add(s);
        }
        List<List<String>> result = new LinkedList<>();
        for(List<String> list : map.values()){
            result.add(list);
        }
        return result;
    }

    String encode(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int f : freq){
            sb.append(f).append("#");
        }
        return sb.toString();
    }
}