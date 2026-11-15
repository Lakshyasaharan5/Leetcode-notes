class SubrectangleQueries {

    /**
            [5,5,5],
            [5,6,6],
            [3,6,6],
            [1,1,1]]

            00,12 -> 5
            11,22 -> 6

            List -> [0,0,1,2,5]

            00 01 02
            10 11 12
            20 21 22
            30 31 32

            5 5 5 
            5 6 5 
            5 5 5


    
     */
    private int[][] rectangle;    
    private List<int[]> queries;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        this.queries = new ArrayList<>();
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        this.queries.add(new int[]{row1, col1, row2, col2, newValue});
    }
    
    public int getValue(int row, int col) {
        for (int i = queries.size() - 1; i >= 0; i--) {
            int[] curr = queries.get(i);
            if (curr[0] <= row && curr[1] <= col && curr[2] >= row && curr[3] >= col) {
                return curr[4];
            }
        }
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */