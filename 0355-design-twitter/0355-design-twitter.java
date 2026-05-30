class Twitter {

    private class Tweet {
        int tweetId;
        int timestamp;
        Tweet next;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    private Map<Integer, Set<Integer>> followingMap;
    private Map<Integer, Tweet> tweetMap;
    private int time;

    public Twitter() {
        followingMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.time++;
        Tweet newTweet = new Tweet(tweetId, this.time);
        if (tweetMap.containsKey(userId)) {
            newTweet.next = tweetMap.get(userId);
        } 
        tweetMap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {        
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        if (tweetMap.containsKey(userId))
            pq.offer(tweetMap.get(userId));
        if (followingMap.containsKey(userId)) {
            for (int followee : followingMap.get(userId)) {
                Tweet head = tweetMap.get(followee);
                if (head != null)
                    pq.offer(head);
            }
        }
        List<Integer> posts = new ArrayList<>();
        int k = 10;
        while (k-- > 0 && !pq.isEmpty()) {
            Tweet curr = pq.poll();            
            posts.add(curr.tweetId);
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return posts;
    }

    public void follow(int followerId, int followeeId) {
        followingMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followingMap.containsKey(followerId))
            followingMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */