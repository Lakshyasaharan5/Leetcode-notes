class Solution {
    /**
    
        ["eat","tea","tan","ate","nat","bat"]
                            i 
        
         aet: eat, tea, ate
         ant: tan

    
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String s : strs) {            
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if (!anagramsMap.containsKey(sorted)) {
                anagramsMap.put(sorted, new ArrayList<>());
            }
            anagramsMap.get(sorted).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : anagramsMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}