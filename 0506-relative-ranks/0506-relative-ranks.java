class Solution {
    public String[] findRelativeRanks(int[] score) {
        if (score.length == 1) return new String[]{"Gold Medal"};
        if (score.length == 2) {
            if (score[0] > score[1]) return new String[]{"Gold Medal", "Silver Medal"};
            return new String[]{"Silver Medal", "Gold Medal"};
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int s : score) pq.add(s);                    
        HashMap<Integer, String> rankMap = new HashMap<>();        
        rankMap.put(pq.poll(), "Gold Medal");        
        rankMap.put(pq.poll(), "Silver Medal");
        rankMap.put(pq.poll(), "Bronze Medal");
        int rank = 4;
        while (!pq.isEmpty()) {
            rankMap.put(pq.poll(), Integer.toString(rank++));
        }
        String[] rankArray = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            rankArray[i] = rankMap.get(score[i]);
        }
        return rankArray;
    }
}