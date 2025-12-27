class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {                    
                    if ((i - 1 < 0 || land[i-1][j] == 0) && (j - 1 < 0 || land[i][j-1] == 0)) {
                        int tmp_i = i, tmp_j = j;
                        while (tmp_i < m && land[tmp_i][j] == 1) tmp_i++;
                        while (tmp_j < n && land[i][tmp_j] == 1) tmp_j++;    
                        groups.add(new int[]{i, j, tmp_i - 1, tmp_j - 1});
                    }
                }
            }
        }
        int[][] res = groups.toArray(new int[groups.size()][]);
        return res;
    }
}