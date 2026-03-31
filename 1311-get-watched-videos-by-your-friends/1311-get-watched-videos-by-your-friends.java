class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);
        int currLevel = 0;
        Set<String> videos = new HashSet<>();
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            while (currSize-- > 0) {
                for (int friend : friends[queue.poll()]) {
                    if (visited.add(friend)) {
                        queue.offer(friend);
                    }
                }
            }
            currLevel++;
            if (currLevel == level) {
                break;
            }
        }
        Map<String, Integer> freq = new HashMap<>();
        while (!queue.isEmpty()) {
            for (String video : watchedVideos.get(queue.poll())) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }            
        }
        List<String> res = new ArrayList<>(freq.keySet());
        res.sort((a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);
            if (fa == fb) {
                return a.compareTo(b);
            }
            return fa - fb;
        });
        return res;
    }
}