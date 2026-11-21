class Solution {
    /**
        qwer qwer qwer qwer 

        rewwwww qw wq wq
                 l
                 r
        remove {w:0, q:1}

        w : 3
        q : 3
        r : 1
        e : 1

    
     */
    public int balancedString(String s) {
        int len = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> remove = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char ch = entry.getKey();
            int fr = entry.getValue();
            if (fr > len / 4) {
                remove.put(ch, fr - len / 4);
            } 
        }

        if (remove.size() == 0) return 0;

        int l = 0, r = 0;
        int shortest = Integer.MAX_VALUE;
        while (r < s.length()) {
            char curr = s.charAt(r);
            if (!remove.containsKey(curr)) {
                r++;
                continue;                
            }
            remove.put(curr, remove.get(curr) - 1);
            while (allRemoved(remove)) {
                shortest = Math.min(shortest, r - l + 1);
                char prev = s.charAt(l);
                if (remove.containsKey(prev)) 
                    remove.put(prev, remove.get(prev) + 1);
                l++;
            }
            r++;
        }
        return shortest;
    }

    private boolean allRemoved(Map<Character, Integer> remove) {
        for (Map.Entry<Character, Integer> entry : remove.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }
}