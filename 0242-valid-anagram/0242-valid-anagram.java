class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) - 1);
        }
        for(int value : freq.values()){
            if (value != 0) return false;
        }
        return true;
    }
}