class Job {
    char name;
    int freq;
    int lastScheduled;
    public Job(char name, int freq, int lastScheduled) {
        this.name = name;
        this.freq = freq;
        this.lastScheduled = lastScheduled;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int ticks = 0;
        int[] freqArray = new int[26];
        for (char t : tasks) {
            freqArray[t - 'A']++;
        }
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) ->  {
            return b.freq - a.freq;
        });
        for (int i = 0; i < 26; i++) {
            if (freqArray[i] > 0) {
                pq.add(new Job((char)('A' + i), freqArray[i], 0));
            }
        }
        Queue<Job> queue = new LinkedList<>();
        while (!pq.isEmpty() || !queue.isEmpty()) {
            if (!pq.isEmpty()) {
                Job curr = pq.poll();
                curr.freq--;
                curr.lastScheduled = ticks;
                if (curr.freq > 0) {
                    queue.offer(curr);
                }
            } 
            while (!queue.isEmpty() && ticks - queue.peek().lastScheduled >= n) {
                pq.offer(queue.poll());
            }
            ticks++;
        }
        return ticks;
    }
}