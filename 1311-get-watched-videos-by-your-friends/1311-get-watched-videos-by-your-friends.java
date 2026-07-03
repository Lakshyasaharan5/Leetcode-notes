class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        que.offer(id);
        visited[id] = true;
        while (!que.isEmpty() && level-- > 0) {
            int currSize = que.size();
            while (currSize-- > 0) {
                int front = que.poll();
                for (int neib : friends[front]) {
                    if (!visited[neib]) {
                        visited[neib] = true;
                        que.offer(neib);
                    }
                }
            }
        }
        if (que.isEmpty()) // nothing at that level
            return new ArrayList<>();

        // create freq map for watched video at that level
        Map<String, Integer> freq = new HashMap<>();
        while (!que.isEmpty()) {
            int front = que.poll();
            for (String video : watchedVideos.get(front)) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }

        // sort based on freq and then based on alphabetically
        List<String> res = new ArrayList<>(freq.keySet());
        res.sort((a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);
            if (fa == fb) 
                return a.compareTo(b);
            return fa - fb;
        });
        return res;
    }
}