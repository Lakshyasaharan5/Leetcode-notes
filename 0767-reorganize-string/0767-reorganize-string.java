class Solution {

    static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {

        // Step 1: Count frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Max heap based on frequency
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (char c : map.keySet()) {
            pq.offer(new Pair(c, map.get(c)));
        }

        StringBuilder sb = new StringBuilder();

        // Step 3: Process two at a time
        while (pq.size() >= 2) {
            Pair first = pq.poll();
            Pair second = pq.poll();

            sb.append(first.ch);
            sb.append(second.ch);

            first.freq--;
            second.freq--;

            if (first.freq > 0) pq.offer(first);
            if (second.freq > 0) pq.offer(second);
        }

        // Step 4: Handle last remaining character
        if (!pq.isEmpty()) {
            Pair last = pq.poll();
            if (last.freq > 1) return "";
            sb.append(last.ch);
        }

        return sb.toString();
    }
}