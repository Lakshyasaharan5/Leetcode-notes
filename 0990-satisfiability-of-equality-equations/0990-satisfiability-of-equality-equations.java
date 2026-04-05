class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;
        for (String eq : equations) {
            if (eq.charAt(1) == '!') continue;
            union(parent, eq.charAt(0) - 'a', eq.charAt(3) - 'a');
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '=') continue;
            if (find(parent, eq.charAt(0) - 'a') == find(parent, eq.charAt(3) - 'a'))
                return false;
        }
        return true;
    }
    
    private int find(int[] parent, int ch) {
        while (ch != parent[ch])
            ch = parent[ch];
        return ch;
    }

    private void union(int[] parent, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);
        parent[pv] = pu;
    }
}