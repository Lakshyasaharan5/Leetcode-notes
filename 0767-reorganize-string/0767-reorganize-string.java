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
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        Pair prev = null;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();            
            sb.append(curr.ch);
            curr.freq--;
            if (prev != null && prev.freq > 0) pq.offer(prev);
            prev = curr;
        }
        if (sb.length() < s.length()) return "";
        return sb.toString();    
    }
}