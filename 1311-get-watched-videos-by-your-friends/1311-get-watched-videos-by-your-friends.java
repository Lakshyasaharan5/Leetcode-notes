class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];

        int[] curr = new int[n];
        int[] next = new int[n];
        int currLen = 0, nextLen = 0;

        curr[currLen++] = id;
        visited[id] = true;

        for (int l = 0; l < level && currLen > 0; l++) {
            nextLen = 0;
            for (int i = 0; i < currLen; i++) {
                for (int neib : friends[curr[i]]) {
                    if (!visited[neib]) {
                        visited[neib] = true;
                        next[nextLen++] = neib;
                    }
                }
            }
            // swap the buffers — no allocation, just reference swap
            int[] tmp = curr; curr = next; next = tmp;
            currLen = nextLen;
        }

        if (currLen == 0) return List.of();

        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < currLen; i++) {
            for (String video : watchedVideos.get(curr[i])) {
                freq.merge(video, 1, Integer::sum);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey()));

        List<String> res = new ArrayList<>(entries.size());
        for (var e : entries) res.add(e.getKey());
        return res;
    }
}