class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        /**
                hello
                world

                [a b c d d f g h i j l e p q .l .. h]
                 a b c d e f g h i j l o p q .r .. w

                hold
         */
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;
        for (int i = 0; i < s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            int pu = find(parent, u);
            int pv = find(parent, v);
            if (pu == pv) continue;
            if (pu < pv) {
                parent[pv] = pu;
            } else {
                parent[pu] = pv;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int parent_ch = find(parent, ch - 'a');
            sb.append((char)(parent_ch + 'a'));
        }        
        return sb.toString();
    }

    private int find(int[] parent, int u) {        
        if (parent[u] == u) return u;
        return parent[u] = find(parent, parent[u]);
    }      
}