class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /**
            [2],
            [3,4],
            [6,5,7],
            [4,1,8,3]

            [11],
            [9,10],
            [7,6,10],
            [4,1,8,3]        
         */
        int rows = triangle.size();
        for (int i = rows - 2; i >= 0; i--) {
            int cols = triangle.get(i).size();
            for (int j = cols - 1; j >= 0; j--) {
                int minNextRow = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                int curr = triangle.get(i).get(j);
                triangle.get(i).set(j, curr + minNextRow);
            }
        }
        return triangle.get(0).get(0);
    }
}