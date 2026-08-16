class Solution {
    public int numTilePossibilities(String tiles) {
        return backtrack(tiles, tiles.toCharArray(), 0);
    }

    private int backtrack(String tiles, char[] arr, int start) {  
        if (start >= arr.length) return 0;      
        boolean[] used = new boolean[26];
        int curr = 0;
        for (int i = start; i < tiles.length(); i++) {
            if (used[arr[i] - 'A']) continue;
            used[arr[i] - 'A'] = true;
            swap(arr, start, i);            
            curr += backtrack(tiles, arr, start + 1) + 1;
            swap(arr, start, i);
        }
        return curr;
    }

    private void swap(char[] arr, int a, int b) {
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

