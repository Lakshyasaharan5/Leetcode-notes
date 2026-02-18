class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String>[] bucket = new ArrayList[501];
        HashMap<String, Integer> freq = new HashMap<>();
        for (String w : words) freq.put(w, freq.getOrDefault(w, 0) + 1);
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            int f = entry.getValue();
            if (bucket[f] == null) bucket[f] = new ArrayList<String>();
            bucket[f].add(entry.getKey());
        }
        List<String> res = new ArrayList<>();
        for (int i = 500; i >= 0 && k > 0; i--) {
            if (bucket[i] == null) continue;
            ArrayList<String> curr = bucket[i];
            Collections.sort(curr);
            for (int j = 0; j < curr.size() && k > 0; j++) {
                k--;
                res.add(curr.get(j));
            }
        }
        return res;
    }
}