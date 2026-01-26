class Pair {
    char ch;
    int freq;

    Pair (char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String reorganizeString(String s) {
        int[] charFreq = new int[26];
        for (char ch : s.toCharArray()){
            charFreq[ch - 'a']++;
            if (charFreq[ch - 'a'] > (s.length() + 1)/2) return "";
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] > 0) {
                pq.offer(new Pair((char)('a' + i), charFreq[i]));
            }
        }
        Pair prev = new Pair('#', 0);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            sb.append(curr.ch);
            curr.freq--;
            if (prev.freq > 0) pq.offer(prev);
            prev = curr;
        }
        if (sb.length() < s.length()) return "";
        return sb.toString();
    }
}