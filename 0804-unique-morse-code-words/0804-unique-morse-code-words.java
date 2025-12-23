class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> stt = new HashSet<>();
        for (String word : words) {
            StringBuilder key = new StringBuilder();
            for (char ch : word.toCharArray()) {
                key.append(morseCode[ch - 'a']);                
            }
            stt.add(key.toString());
        }
        return stt.size();
    }
}