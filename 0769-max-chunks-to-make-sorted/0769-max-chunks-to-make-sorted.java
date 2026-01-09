class Solution {
    public int maxChunksToSorted(int[] arr) {
        // 2,3,4,1,5,0,6,7
                           
        // 0,1,2,3,4,5,6,7,8,9
        // 0,2,4,3,1,9,5,6,7,8
        //           l
        int chunks = 0, maxReach = 0;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            maxReach = Math.max(maxReach, indexMap.get(i));
            if (i == maxReach) chunks ++;
        }
        return chunks;
    }
}