class Solution {
    public int findCircleNum(int[][] isConnected) {
        // [1,0,0,1],
        // [0,1,1,0],
        // [0,1,1,1],
        // [1,0,1,1]
        // [0,1,2,3,4]
        //  0,1,2,3,4
        int n = isConnected.length;
        int[] parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    union(parent, i+1, j+1);
                }
            }
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            if(find(parent, i) == i) count++;
        }
        return count;
    }

    private int find(int[] parent, int x){
        while(parent[x] != x){
            x = parent[x];
        }
        return x;
    }

    private void union(int[] parent, int a, int b){
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}