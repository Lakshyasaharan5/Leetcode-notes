import java.util.*;

class Solution {
    private double[] prob;   // probability of choosing own index
    private int[] alias;     // fallback index
    private Random rand;
    private int n;

    public Solution(int[] w) {
        n = w.length;
        prob = new double[n];
        alias = new int[n];
        rand = new Random();

        // Step 1: normalize weights to sum = n
        double sum = 0.0;
        for (int x : w) sum += x;
        double[] scaled = new double[n];
        for (int i = 0; i < n; i++) {
            scaled[i] = (w[i] * 1.0 * n) / sum;
        }

        // Step 2: separate into small and large lists
        Deque<Integer> small = new ArrayDeque<>();
        Deque<Integer> large = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (scaled[i] < 1.0) small.add(i);
            else large.add(i);
        }

        // Step 3: build prob + alias tables
        while (!small.isEmpty() && !large.isEmpty()) {
            int s = small.removeLast();
            int l = large.removeLast();
            prob[s] = scaled[s];   // keep its own probability
            alias[s] = l;          // fallback to a large bucket

            // reduce large bucket
            scaled[l] = scaled[l] - (1.0 - prob[s]);
            if (scaled[l] < 1.0) small.add(l);
            else large.add(l);
        }

        // Remaining buckets → prob = 1 (no alias needed)
        while (!small.isEmpty()) {
            prob[small.removeLast()] = 1.0;
        }
        while (!large.isEmpty()) {
            prob[large.removeLast()] = 1.0;
        }
    }

    public int pickIndex() {
        int i = rand.nextInt(n);        // pick a bucket
        double coin = rand.nextDouble(); // coin flip
        if (coin < prob[i]) return i;
        else return alias[i];
    }
}
